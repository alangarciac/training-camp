package training.concurrent;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ExecutorServicesNumberOfThreads {

    public static void main(String[] args) throws InterruptedException {

        Log("Available processors: " + Runtime.getRuntime().availableProcessors());
        Log("Parallelism of your CPU: " + ForkJoinPool.commonPool().getParallelism());

        List<ExecutorService> executorServices = Arrays.asList(
                //Executors.newCachedThreadPool(),
                Executors.newFixedThreadPool(10)
                //Executors.newSingleThreadExecutor(),
                //Executors.newWorkStealingPool(),
                //Executors.newScheduledThreadPool(5),
                //ForkJoinPool.commonPool()
        );

        List<Callable<Object>> tasks = Stream.generate(ExecutorServicesNumberOfThreads::getTaskSleepUnSegundo)
                .limit(100)
                .collect(Collectors.toList());

        for (ExecutorService executorService : executorServices) {
            Instant start = Instant.now();
            executorService.invokeAll(tasks);
            Log("time:" + Duration.between(start, Instant.now()));
        }

        executorServices.stream().forEach(ExecutorService::shutdown);
    }

    private static Callable<Object> getTaskSleepUnSegundo() {
        return Executors.callable(()->{
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

    private static void Log(Object message) {
        System.out.println(String.format("%s", message.toString()));
    }

}
