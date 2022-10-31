package org.example.deep;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CompletableFutureDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> futureTask = new FutureTask<>(new MyThread2());
        new Thread(futureTask,"t1").start();
        System.out.println("------时间流逝-----");
        Thread.sleep(2000);
        System.out.println(futureTask.get());
    }
}

class MyThread2 implements Callable<String>{

    @Override
    public String call() throws Exception {
        System.out.println("老师让学生拿水，自己开始讲课");
        return "学生拿到水了！";
    }
}
