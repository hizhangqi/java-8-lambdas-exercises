package com.systeminfos.interview.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 实现两线程打印奇偶数
 */
public class Thread2PrintOdevityDemo {

    static volatile int a = 1;

    public static void main(String[] args) throws InterruptedException {
        //extracted1();
        //extracted2();
        extracted3();
    }

    private static void extracted1() {
        Object lock = new Object();
        Thread thread1 = new Thread(() -> {
            while (true) {
                synchronized (lock) {
                    if (a > 100) {
                        break;
                    }
                    if (a % 2 == 1) {
                        System.out.println("奇数：" + a);
                        a++;
                    }
                }
            }
        });
        thread1.setName("thread1-");

        Thread thread2 = new Thread(() -> {
            while (true) {
                synchronized (lock) {
                    if (a > 100) {
                        break;
                    }
                    if (a % 2 == 0) {
                        System.out.println("偶数：" + a);
                        a++;
                    }
                }
            }
        });
        thread2.setName("thread2-");

        thread1.start();
        thread2.start();
    }

    private static void extracted2() {
        Lock lock = new ReentrantLock();
        Thread thread1 = new Thread(() -> {
            while (true) {
                try {
                    lock.tryLock(1, TimeUnit.SECONDS);
                    if (a > 100) {
                        break;
                    }
                    if (a % 2 == 1) {
                        System.out.println(Thread.currentThread().getName() + " 奇数：" + a);
                        a++;
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    lock.unlock();
                }
            }
        });
        thread1.setName("thread1-");

        Thread thread2 = new Thread(() -> {
            while (true) {
                try {
                    lock.tryLock(1, TimeUnit.SECONDS);
                    if (a > 100) {
                        break;
                    }
                    if (a % 2 == 0) {
                        System.out.println(Thread.currentThread().getName() + " 偶数：" + a);
                        a++;
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    lock.unlock();
                }
            }
        });
        thread2.setName("thread2-");

        thread1.start();
        thread2.start();
    }

    /**
     * 实现五线程有序间隔执行
     */
    private static void extracted3() {
        final int threadCount = 5;
        Lock lock = new ReentrantLock();
        Condition[] conditions = new Condition[threadCount];
        for (int i = 0; i < threadCount; i++) {
            conditions[i] = lock.newCondition();
        }
        for (int i = 0; i < threadCount; i++) {
            final int threadIndex = i;
            Thread thread = new Thread(() -> {
                while (true) {
                    try {
                        lock.lock();
                        while (a % threadCount != threadIndex) {
                            conditions[threadIndex].await();
                        }
                        if (a > 100) {
                            break;
                        }
                        System.out.println(Thread.currentThread().getName() + " 打印：" + a);
                        a++;
                        conditions[(threadIndex + 1) % threadCount].signal();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    } finally {
                        lock.unlock();
                    }
                }
            });
            thread.setName("thread-" + threadIndex);
            thread.start();
        }
    }

}
