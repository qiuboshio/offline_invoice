package com.pax.offline_invoice.common.lock.highConcurrency;

/**
 * @projectname offline_invoice
 * @Classname WriteTask
 * @Description 写任务
 * @Version 1.0.0
 * @Date 2022/9/23 13:37
 * @Created by qiuzepeng
 */
class WriteTask implements Runnable {
    private RWDictionary dictionary;

    public WriteTask(RWDictionary dictionary) {
        this.dictionary = dictionary;
    }

    @Override
    public void run() {
        int i = 0;
        while (i<3) {
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String name = Thread.currentThread().getName();
            dictionary.put("hello"+i, name + "---" + i);
            System.out.println("写入hello"+i+":"+name + "---" + i);
            i++;

        }
    }
}
