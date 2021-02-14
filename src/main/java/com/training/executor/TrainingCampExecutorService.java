package com.training.executor;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.*;

public class TrainingCampExecutorService {

    private static final Instant INIT = Instant.now();

    public static void main(String[] args) {

        threadTest();
        executorSingleThreadTest();
        executorCallableTest();

    }

    private static void executorCallableTest() {

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<String> futureTask1 = executorService.submit(getCallableTask("1"));

        try {
            Log(futureTask1.isDone());
            String result = futureTask1.get();
            Log(futureTask1.isDone());
            Log(result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        executorService.shutdown();
    }

    private static void executorSingleThreadTest() {

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit(getRunnableTask("1"));
        executorService.submit(getRunnableTask("2"));
        executorService.shutdown();

    }

    private static void threadTest() {

   
    }

    private static Runnable getRunnableTask(String number) {
        return () -> {
                try {
                    Log("Start task " + number);
                    TimeUnit.SECONDS.sleep(3);
                    Log("End task " + number);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };
    }

    private static Callable<String> getCallableTask(String s) {
        return ()->{
                Log("Start task: " + s);
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Log("End task: " + s);
                return ("Result of task:  " + s);
        };
    }

    private static void Log(Object message) {
        System.out.println(String.format("%s [%s] %s",
                Duration.between(INIT, Instant.now()), Thread.currentThread().getName(), message.toString()));
    }

}
