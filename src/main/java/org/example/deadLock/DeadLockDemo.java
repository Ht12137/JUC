package org.example.deadLock;

/**
 * @author ht
 */
public class DeadLockDemo {
    public static void main(String[] args) {
        Object a = new Object();
        Object b = new Object();
        new Thread(()->{
            synchronized (a){
                System.out.println(Thread.currentThread().getName()+"\t我持有了a锁，希望获得b锁");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (b){
                    System.out.println(Thread.currentThread().getName()+"\t成功获得b锁");
                }
            }
        },"A").start();

        new Thread(()->{
            synchronized (b){
                System.out.println(Thread.currentThread().getName()+"\t我持有了b锁，希望获得a锁");
                synchronized (a){
                    System.out.println(Thread.currentThread().getName()+"\t成功获得a锁");
                }
            }
        },"B").start();


    }
}
