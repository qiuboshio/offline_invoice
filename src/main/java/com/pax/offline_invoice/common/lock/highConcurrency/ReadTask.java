package com.pax.offline_invoice.common.lock.highConcurrency;

/**
 * @projectname offline_invoice
 * @Classname ReadTask
 * @Description 读任务
 * @Version 1.0.0
 * @Date 2022/9/23 13:38
 * @Created by qiuzepeng
 */
class ReadTask implements Runnable {
    private RWDictionary dictionary;

    public ReadTask(RWDictionary dictionary) {
        this.dictionary = dictionary;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String[] keys = dictionary.allKeys();
            int i=1;
            for (String key : keys) {
                Object value = dictionary.get(key);
                String name = Thread.currentThread().getName();
                System.out.println(name+"读取"+key + ":" + value);
                i++;
            }
        }
    }
}

