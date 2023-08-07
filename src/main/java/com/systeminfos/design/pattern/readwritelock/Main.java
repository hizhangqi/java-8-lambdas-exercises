package com.systeminfos.design.pattern.readwritelock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class SharedResource {
    private int data;
    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private final Lock readLock = readWriteLock.readLock();
    private final Lock writeLock = readWriteLock.writeLock();

    public int readData() {
        readLock.lock();
        try {
            return data;
        } finally {
            readLock.unlock();
        }
    }

    public void writeData(int newData) {
        writeLock.lock();
        try {
            data = newData;
        } finally {
            writeLock.unlock();
        }
    }
}

/**
 * 它用于优化读取和写入操作的并发性。读写锁允许多个线程同时读取共享资源，但只允许一个线程进行写入操作
 */
public class Main {
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();

        // 创建多个读取线程
        for (int i = 0; i < 5; i++) {
            Thread readerThread = new Thread(() -> {
                int data = sharedResource.readData();
                System.out.println(Thread.currentThread().getName() + " read data: " + data);
            });
            readerThread.start();
        }

        // 创建一个写入线程
        Thread writerThread = new Thread(() -> {
            sharedResource.writeData(42);
            System.out.println(Thread.currentThread().getName() + " wrote data: 42");
        });
        writerThread.start();
    }

}
