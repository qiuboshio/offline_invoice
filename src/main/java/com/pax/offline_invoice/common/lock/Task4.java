package com.pax.offline_invoice.common.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @projectname offline_invoice
 * @Classname Task4
 * @Description TODO
 * @Version 1.0.0
 * @Date 2022/9/23 11:55
 * @Created by qiuzepeng
 */
class Task4 implements Runnable {
    private ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock(true);
    private Lock writeLock = readWriteLock.writeLock();

    @Override
    public void run() {
        writeLock.lock();
        try {
            Thread.sleep(3000L);
            System.out.println(Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            writeLock.unlock();
        }
    }

}
