package com.pax.offline_invoice.common.lock;

/**
 * @projectname offline_invoice
 * @Classname LockDemo2
 * @Description 论证读锁是共享锁
 * @Version 1.0.0
 * @Date 2022/9/23 11:42
 * @Created by qiuzepeng
 */
public class LockDemo2 {
    public static void main(String[] args) {
        Task4 task = new Task4();
        Thread t1 = new Thread(task, "线程一");
        Thread t2 = new Thread(task, "线程二");
        Thread t3 = new Thread(task, "线程三");
        t1.start();
        t2.start();
        t3.start();
    }

}
