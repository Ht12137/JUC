package org.example.interrupt;

/**
 * @author ht
 */
public class InterruptDemo3 {
    public static void main(String[] args) {
        System.out.println("当前的线程状态\t" + Thread.interrupted());
        System.out.println("当前的线程状态\t" + Thread.interrupted());
        System.out.println("-------1");
        Thread.currentThread().interrupt();
        System.out.println("当前的线程状态\t" + Thread.interrupted());
        System.out.println("当前的线程状态\t" + Thread.interrupted());
    }
}
