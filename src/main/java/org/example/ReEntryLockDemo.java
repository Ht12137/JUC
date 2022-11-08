package org.example;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ht
 */
public class ReEntryLockDemo {


    public synchronized void m3(){
        System.out.println("asdasdas");
    }


    public synchronized void m2(){
        m3();
    }


    public synchronized void m1(){
        m2();
    }

    static Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + "\t" + "start");
        new ReEntryLockDemo().m1();
        System.out.println(Thread.currentThread().getName() + "\t" + "end");
        lock.lock();
        try {
            System.out.println("第一层");
            lock.lock();
            try {
                System.out.println("第二层");
            }finally {
                lock.unlock();
            }
        }finally {
            lock.unlock();
        }

    }
}
