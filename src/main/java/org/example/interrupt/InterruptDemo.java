package org.example.interrupt;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author ht
 */
public class InterruptDemo {

    static volatile boolean isStop = false;

    static AtomicBoolean atomicBoolean = new AtomicBoolean();

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(() -> {
            while (true) {
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println(Thread.currentThread().getName() + "\t is interrupted");
                    break;
                }
                System.out.println("-----hello interrupt Api");
            }
        }, "t1");

        t1.start();

        Thread.sleep(2000);
        new Thread(t1::interrupt,"t2").start();
        
    }

    public static void MethodOfAtomicBoolean() throws InterruptedException {
        new Thread(()->{
            while (true){
                if(atomicBoolean.get()){
                    System.out.println(Thread.currentThread().getName() + "\t atomicBoolean 变成true");
                    break;
                }

                System.out.println("-----hello atomicBoolean");
            }
        },"t1").start();

        Thread.sleep(2000);
        new Thread(()->{
            atomicBoolean.set(true);
        },"t2").start();
    }

    public static void MethodOfVolatile() throws InterruptedException {
        new Thread(()->{
            while (true){
                if(isStop){
                    System.out.println(Thread.currentThread().getName() + "\t isStop 变成true");
                    break;
                }

                System.out.println("-----hello volatile");
            }
        },"t1").start();

        Thread.sleep(2000);
        new Thread(()->{
            isStop = true;
        },"t2").start();
    }

}
