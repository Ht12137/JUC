package org.example.lock;

import java.util.concurrent.locks.ReentrantLock;

class LTicket{
    public static int num = 30;

    private final ReentrantLock lock = new ReentrantLock(true);

    public void sell(){

        lock.lock();
        try{
            if(num>0){
                System.out.println(Thread.currentThread().getName() +"卖到"+ num--);
            }
        }finally {
            lock.unlock();
        }


    }

}

public class LSaleTicket {
    public static void main(String[] args) {
        LTicket lTicket = new LTicket();
        new Thread(()->{
            for (int i = 0; i < 40; i++) {
                lTicket.sell();
            }
        },"AA").start();
        new Thread(()->{
            for (int i = 0; i < 40; i++) {
                lTicket.sell();
            }
        },"BB").start();
        new Thread(()->{
            for (int i = 0; i < 40; i++) {
                lTicket.sell();
            }
        },"CC").start();
    }
}
