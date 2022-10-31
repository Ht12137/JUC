package org.example.deep;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class FutureApiDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        FutureTask<String> futureTask = new FutureTask<>(() -> {
            System.out.println(Thread.currentThread().getName() + "\t ------come in");
            Thread.sleep(5000);
            return "task over";
        });
        new Thread(futureTask,"t1").start();


        System.out.println(Thread.currentThread().getName() + "\t-----开始忙其它的任务了");


        while (true){
            if (futureTask.isDone()){
                System.out.println(futureTask.get());
                break;
            }else {
                System.out.println("还在执行，这任务很重，你别催！！");
                Thread.sleep(300);
            }
        }






    }

}
