package com.pax.offline_invoice.common.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @projectname offline_invoice
 * @Classname Task3
 * @Description 论证读锁是共享锁
 * @Version 1.0.0
 * @Date 2022/9/23 11:42
 * @Created by qiuzepeng
 */
class Task3 implements Runnable {
    private ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock(true);
    private Lock readLock = readWriteLock.readLock();

    @Override
    public void run() {
        readLock.lock();
        try {
            Thread.sleep(3000L);
            System.out.println(Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            readLock.unlock();
        }
    }
}
