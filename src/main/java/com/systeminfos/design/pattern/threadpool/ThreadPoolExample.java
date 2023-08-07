package com.systeminfos.design.pattern.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Task implements Runnable {
    private final int taskId;

    public Task(int taskId) {
        this.taskId = taskId;
    }

    @Override
    public void run() {
        System.out.println("Task " + taskId + " is being executed by thread " + Thread.currentThread().getName());
    }
}

public class ThreadPoolExample {
    public static void main(String[] args) {
        int numThreads = 3; // 线程池中的线程数量
        int maxTasks = 10; // 总共的任务数量

        // 创建一个固定大小的线程池
        ExecutorService executor = Executors.newFixedThreadPool(numThreads);

        // 提交任务到线程池执行
        for (int i = 1; i <= maxTasks; i++) {
            Runnable task = new Task(i);
            executor.execute(task);
        }

        // 关闭线程池
        executor.shutdown();
        System.out.println(11);
    }
}
