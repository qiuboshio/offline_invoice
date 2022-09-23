package com.pax.offline_invoice.common.lock.highConcurrency;

/**
 * @projectname offline_invoice
 * @Classname Demo
 * @Description TODO
 * @Version 1.0.0
 * @Date 2022/9/23 12:23
 * @Created by qiuzepeng
 */
public class Demo {
    public static void main(String[] args) {
        //数据存储容器
        RWDictionary dictionary = new RWDictionary();
        //写任务
        WriteTask writeTask = new WriteTask(dictionary);
        //读任务
        ReadTask readTask = new ReadTask(dictionary);

        Thread write1 = new Thread(writeTask, "写入线程一");
        Thread write2 = new Thread(writeTask, "写入线程二");
        Thread write3 = new Thread(writeTask, "写入线程三");
        Thread read1 = new Thread(readTask, "读取线程一");
        Thread read2 = new Thread(readTask, "读取线程二");
        Thread read3 = new Thread(readTask, "读取线程三");
        write1.start();
        write2.start();
        write3.start();
        read1.start();
        read2.start();
        read3.start();
    }

}
