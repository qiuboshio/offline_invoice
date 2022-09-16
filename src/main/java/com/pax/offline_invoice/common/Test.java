package com.pax.offline_invoice.common;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @projectname offline_invoice
 * @Classname Test
 * @Description TODO
 * @Version 1.0.0
 * @Date 2022/9/14 20:24
 * @Created by qiuzepeng
 */
public class Test {
    public static void main(String[] args) {
        testlock();
    }
    public static void testlock() {
        Lock lock = new ReentrantLock();
        Thread t = new Thread(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                lock.lock();
                try {
                    Thread.sleep(1000);
                    System.out.println("goon");
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }

        });

        t.start();
        System.out.println("start");
        lock.lock();
        System.out.println("over");
        lock.unlock();
    }

}
