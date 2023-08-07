package com.systeminfos.design.pattern.Synchronization;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class SharedResource2 {
    private int data;
    private boolean isProduced = false;
    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();

    public void produce(int newData) {
        lock.lock();
        try {
            while (isProduced) {
                condition.await();
            }
            data = newData;
            isProduced = true;
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public int consume() {
        lock.lock();
        try {
            while (!isProduced) {
                condition.await();
            }
            isProduced = false;
            condition.signalAll();
            return data;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return -1;
        } finally {
            lock.unlock();
        }
    }
}

/**
 * 条件变量（Condition Variable）：在复杂的同步需求中使用条件变量等待和通知线程
 */
public class Main2 {
    public static void main(String[] args) {
        SharedResource2 sharedResource = new SharedResource2();

        Runnable producer = () -> {
            for (int i = 0; i < 5; i++) {
                sharedResource.produce(i);
            }
        };

        Runnable consumer = () -> {
            for (int i = 0; i < 5; i++) {
                int data = sharedResource.consume();
                System.out.println("Consumed: " + data);
            }
        };

        Thread producerThread = new Thread(producer);
        Thread consumerThread = new Thread(consumer);

        producerThread.start();
        consumerThread.start();

        try {
            producerThread.join();
            consumerThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
