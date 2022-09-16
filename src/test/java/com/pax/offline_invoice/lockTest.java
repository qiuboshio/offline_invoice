package com.pax.offline_invoice;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @projectname offline_invoice
 * @Classname lockTest
 * @Description TODO
 * @Version 1.0.0
 * @Date 2022/9/14 20:22
 * @Created by qiuzepeng
 */
@SpringBootTest
public class lockTest {
    @Test
    public static void testlock() {
        Lock lock = new ReentrantLock();
        Thread t = new Thread(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                lock.lock();
                try {
                    Thread.sleep(1000);
                    System.out.println("goon");
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }

        });

        t.start();
        System.out.println("start");
        lock.lock();
        System.out.println("over");
        lock.unlock();
    }

}
