package com.pax.offline_invoice.common.lock.highConcurrency;

import java.util.HashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @projectname offline_invoice
 * @Classname RWDictionary
 * @Description 数据管理容器
 * @Version 1.0.0
 * @Date 2022/9/23 13:39
 * @Created by qiuzepeng
 */
class RWDictionary {
    //存储数据
    private final HashMap<String, Object> map = new HashMap<>();
    //读写锁
    private final ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock(true);
    //读锁
    private final Lock r = readWriteLock.readLock();
    //写锁
    private final Lock w = readWriteLock.writeLock();

    /**
     * 获取数据
     */
    public Object get(String key) {
        r.lock();
        try {
            return map.get(key);
        } finally {
            r.unlock();
        }
    }

    /**
     * 获取所有键
     */
    public String[] allKeys() {
        r.lock();
        try {
            String[] strings = map.keySet().toArray(new String[0]);
            return strings;
        } finally {
            r.unlock();
        }
    }

    /**
     * 写入数据
     */
    public Object put(String key, Object value) {
        w.lock();
        try {
            return map.put(key, value);
        } finally {
            w.unlock();
        }
    }

    /**
     * 清理所有数据
     */
    public void clear() {
        w.lock();
        try {
            map.clear();
        } finally {
            w.unlock();
        }
    }
}
