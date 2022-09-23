package com.pax.offline_invoice.common.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @projectname offline_invoice
 * @Classname Task2
 * @Description TODO
 * @Version 1.0.0
 * @Date 2022/9/23 11:38
 * @Created by qiuzepeng
 */
class Task2 implements Runnable {
    private Lock lock;
    private Condition condition;

    public Task2(Lock lock, Condition condition) {
        this.lock = lock;
        this.condition = condition;
    }

    @Override
    public void run() {
        lock.lock();
        try {
            //等待
            condition.await();
            System.out.println("hello world");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

