package org.example.interrupt;

import java.util.concurrent.TimeUnit;

/**
 * @author ht
 */
public class InterruptDemo02 {
    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            while (true){
                System.out.println(Thread.currentThread().getName() + "正在运行中");
                if(Thread.currentThread().isInterrupted()){
                    System.out.println(Thread.currentThread().getName() +"\t 已经被中断了");
                    break;
                }
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    e.printStackTrace();
                }
            }
        }, "t1");
        t1.start();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        new Thread(()->{
            t1.interrupt();
        },"t2").start();
    }
}
