package training.concurrent;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ConcurrentMaps {

    public final static int THREAD_POOL_SIZE = 5;

    public static Map<String, Integer> hashMapObject = null;
    public static Map<String, Integer> synchronizedMapObject = null;
    public static Map<String, Integer> concurrentHashMapObject = null;

    public static void main(String[] args) throws InterruptedException {

        Map<String, Integer> best = null;
        Long smallestAVG = Long.MAX_VALUE;
        Long avg;

        // Test with HashMap Object
        hashMapObject = new HashMap<>();
        avg = execute(hashMapObject);
        if(avg < smallestAVG){
            smallestAVG = avg;
            best = hashMapObject;
        }

        // synchronizedMap: Every read/write operation needs to acquire lock
        synchronizedMapObject = Collections.synchronizedMap(new HashMap<String, Integer>());
        avg = execute(synchronizedMapObject);
        if(avg < smallestAVG){
            smallestAVG = avg;
            best = synchronizedMapObject;
        }

        // ConcurrentHashMap: There is no locking at the object level
        concurrentHashMapObject = new ConcurrentHashMap<String, Integer>();
        avg = execute(concurrentHashMapObject);
        if(avg < smallestAVG){
            smallestAVG = avg;
            best = concurrentHashMapObject;
        }

        System.out.println("Definitely " + best.getClass() + " whit AVG of " + smallestAVG + "ms. is the better approach to use in concurrent environments.");
    }

    private static long execute(final Map<String, Integer> map) throws InterruptedException {
        System.out.println("Test started for: " + map.getClass());
        long averageTime = 0;
        for (int i = 0; i < THREAD_POOL_SIZE; i++) {

            long startTime = System.nanoTime();
            ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

            for (int j = 0; j < THREAD_POOL_SIZE; j++) {
                executor.execute(new Runnable() {
                    @SuppressWarnings("unused")
                    @Override
                    public void run() {

                        for (int i = 0; i < 500000; i++) {
                            Integer random = (int) Math.ceil(Math.random() * 550000);

                            // Retrieve value. We are not using it anywhere
                            Integer value = map.get(String.valueOf(random));

                            // Put value
                            map.put(String.valueOf(random), random);
                        }
                    }
                });
            }

            // This method does not wait for previously submitted tasks to complete execution.
            executor.shutdown();

            // Blocks until all tasks have completed execution after a shutdown request, or the timeout occurs, or the current thread is
            // interrupted, whichever happens first.
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);

            long entTime = System.nanoTime();
            long totalTime = (entTime - startTime) / 1000000L;
            averageTime += totalTime;
            System.out.println("500K entried added/retrieved in " + totalTime + " ms");
        }
        long avg = averageTime / 5;
        System.out.println("For " + map.getClass() + " the average time is " + avg + " ms\n");
        return avg;
    }

}
