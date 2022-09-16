package com.pax.offline_invoice.common;

/**
 * @projectname offline_invoice
 * @Classname SaleTicket_Synchronized
 * @Description TODO
 * @Version 1.0.0
 * @Date 2022/9/14 20:39
 * @Created by qiuzepeng
 */
public class SaleTicket_Synchronized {
    public static void main(String[] args) {
        Ticket_Synchronized ticket_synchronized = new Ticket_Synchronized();

        new Thread(() -> { for (int i = 0; i <= 100; i++) ticket_synchronized.sale(); }, "A").start();
        new Thread(() -> { for (int i = 0; i <= 100; i++) ticket_synchronized.sale(); }, "B").start();
        new Thread(() -> { for (int i = 0; i <= 100; i++) ticket_synchronized.sale(); }, "C").start();
    }
}

// 资源类，通过多线程操作同一个资源类
class Ticket_Synchronized{
    private int ticket = 100;

    public synchronized void sale(){
        if (ticket > 0){
            System.out.println(Thread.currentThread().getName() + "卖出出了第" + ticket-- + "张票，剩余" + ticket + "张");
        }
    }
}
