package com.pax.offline_invoice.common.lock;

/**
 * @projectname offline_invoice
 * @Classname LockDemo
 * @Description TODO
 * @Version 1.0.0
 * @Date 2022/9/23 11:10
 * @Created by qiuzepeng
 */
public class LockDemo {
    public static void main(String[] args) {

        Task1 task = new Task1();
        new Thread(task).start();
        new Thread(task).start();
        new Thread(task).start();
    }
}
