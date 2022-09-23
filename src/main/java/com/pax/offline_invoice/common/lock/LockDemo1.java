package com.pax.offline_invoice.common.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @projectname offline_invoice
 * @Classname LockDemo1
 * @Description TODO
 * @Version 1.0.0
 * @Date 2022/9/23 11:37
 * @Created by qiuzepeng
 */
public class LockDemo1 {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        Task2 task = new Task2(lock, condition);
        new Thread(task).start();
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock.lock();
        //唤醒
        condition.signal();
        lock.unlock();
    }

}
