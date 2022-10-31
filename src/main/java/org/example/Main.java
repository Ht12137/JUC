package org.example;

public class Main {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "::" + Thread.currentThread().isDaemon());
            while (true) {

            }
        }, "用户线程");
        thread.setDaemon(true);
        thread.start();

        System.out.println(Thread.currentThread().getName() + "over");
    }
}