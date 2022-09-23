package com.pax.offline_invoice.common.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @projectname offline_invoice
 * @Classname Task
 * @Description 阻塞锁
 * @Version 1.0.0
 * @Date 2022/9/23 11:16
 * @Created by qiuzepeng
 */
class Task implements Runnable {
    private Lock lock = new ReentrantLock();

    @Override
    public void run() {
        lock.lock();
        try {
            Thread.sleep(3000L);
            System.out.println(Thread.currentThread().getName() + " hello world");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}