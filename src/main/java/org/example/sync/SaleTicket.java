package org.example.sync;

public class SaleTicket {
    public static void main(String[] args) {

        for (int i = 0; i < 13; i++) {
            new Thread(new sale(),"asd").start();
        }

    }
}

class sale implements Runnable{

    public static Shop shop = new Shop();

    @Override
    public void run() {
        shop.saleTicket();
    }
}

class Shop{

    public static int ticket = 10;

    public Shop() {
    }

    public static int getTicket() {
        return ticket;
    }

    public synchronized  void saleTicket() {
        if(ticket<=0){
            System.out.println("票卖完了");
            return;
        }
        ticket = ticket -1;
        System.out.println("票的数量是" + ticket);
    }
}
