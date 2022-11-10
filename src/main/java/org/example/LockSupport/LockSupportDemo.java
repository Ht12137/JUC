package org.example.LockSupport;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

@SuppressWarnings("ALL")
public class LockSupportDemo {
    public static void main(String[] args) {

        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        new Thread(()->{
                lock.lock();
                try {
                    System.out.println(Thread.currentThread().getName() + "开始运作,---即将进入等待状态");
                    condition.await();
                    System.out.println(Thread.currentThread().getName()+"我被唤醒啦");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    lock.unlock();
                }
        },"t1").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        new Thread(()->{
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + "我的任务是唤醒线程");
                condition.signal();
            }finally {
                lock.unlock();
            }
        },"t2").start();

    }

    public static void m1(){
        Object objectLock = new Object();

        new Thread(()->{
            synchronized (objectLock){
                System.out.println(Thread.currentThread().getName() + "开始运作,---即将进入等待状态");
                try {
                    objectLock.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread().getName()+"我被唤醒啦");
            }
        },"t1").start();
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        new Thread(()->{
            synchronized (objectLock){
                System.out.println(Thread.currentThread().getName() + "我的任务是唤醒线程");
                objectLock.notify();
            }
        },"t2").start();
    }
}
