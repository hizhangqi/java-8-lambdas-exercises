package com.systeminfos.design.pattern.Synchronization;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class SharedResource {
    private int count = 0;
    private final Lock lock = new ReentrantLock();

    public void increment() {
        lock.lock();
        try {
            count++;
        } finally {
            lock.unlock();
        }
    }

    public int getCount() {
        return count;
    }
}

/**
 * 互斥锁（Mutex）：使用锁来保护共享资源，确保同一时间只有一个线程可以访问
 */
public class Main {
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();

        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) {
                sharedResource.increment();
            }
        };

        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);
        Thread thread3 = new Thread(task);
        Thread thread4 = new Thread(task);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final count: " + sharedResource.getCount());
    }
}
