package com.pax.offline_invoice.common.lock;

import lombok.SneakyThrows;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @projectname offline_invoice
 * @Classname Task1
 * @Description 非阻塞锁，只要没有过超时时间就会尝试获取
 * @Version 1.0.0
 * @Date 2022/9/23 11:19
 * @Created by qiuzepeng
 */
class Task1 implements Runnable {
    private Lock lock = new ReentrantLock();

    @SneakyThrows
    @Override
    public void run() {
        if (lock.tryLock(7000L, TimeUnit.MILLISECONDS)) {
            try {
                Thread.sleep(3000L);
                System.out.println(Thread.currentThread().getName() + ": hello world");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(Thread.currentThread().getName() + "释放锁");
                lock.unlock();
            }
        } else {
            System.out.println(Thread.currentThread().getName() + ": 锁被占用，执行其他任务！");
        }
    }
}
