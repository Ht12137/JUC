package org.example.deep;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class FutureThreadPoolDemo {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        m1();
        m2();
    }

    private static void m2() throws InterruptedException {
        long startTime = System.currentTimeMillis();
        Thread.sleep(500);
        Thread.sleep(300);
        Thread.sleep(1000);
        long endTime = System.currentTimeMillis();

        System.out.println("程序执行的时间为：" + (endTime - startTime));
    }

    private static void m1() throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        long startTime = System.currentTimeMillis();

        FutureTask<String> task1 = new FutureTask<>(() -> {
            Thread.sleep(500);
            return "task1";
        });

        executorService.submit(task1);


        FutureTask<String> task2 = new FutureTask<>(() -> {
            Thread.sleep(300);
            return "task2";
        });

        executorService.submit(task2);

        Thread.sleep(1000);

        long endTime = System.currentTimeMillis();

        task1.get();
        task2.get();
        System.out.println("程序执行的时间为：" + (endTime - startTime));


        executorService.shutdown();
    }

}
