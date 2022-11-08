package org.example.demo8;



class Phone{
    public static synchronized void sendEmail() throws InterruptedException {
        Thread.sleep(3000);
        System.out.println("-----sendEmail");
    }

    public  synchronized void sendSMS(){
        System.out.println("-----sendSMS");
    }

    public void hello(){
        System.out.println("-----hello");
    }
}


public class demo8 {
    public static void main(String[] args) throws InterruptedException {
        Phone phone = new Phone();
        Phone phone2 = new Phone();
        new Thread(()-> {
            try {
                phone.sendEmail();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        },"a").start();

        Thread.sleep(2000);

        new Thread(()->{
            phone2.sendSMS();
        },"b").start();
    }
}
