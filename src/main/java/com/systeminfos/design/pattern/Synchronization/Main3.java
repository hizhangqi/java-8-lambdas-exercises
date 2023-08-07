package com.systeminfos.design.pattern.Synchronization;

import java.util.concurrent.Semaphore;

class SharedResource3 {
    private int count = 0;
    private final Semaphore semaphore = new Semaphore(1);

    public void increment() {
        try {
            semaphore.acquire();
            count++;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
    }

    public int getCount() {
        return count;
    }
}

/**
 * 信号量（Semaphore）：限制同时访问某个资源的线程数量。
 */
public class Main3 {
    public static void main(String[] args) {
        SharedResource3 sharedResource = new SharedResource3();

        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) {
                sharedResource.increment();
            }
        };

        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final count: " + sharedResource.getCount());
    }
}
