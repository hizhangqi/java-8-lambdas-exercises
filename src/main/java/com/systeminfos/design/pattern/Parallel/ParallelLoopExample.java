package com.systeminfos.design.pattern.Parallel;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 并行循环模式：将一个大的循环任务分成多个小的循环任务，然后并行执行这些小任务。
 */
public class ParallelLoopExample {
    public static void main(String[] args) {
        int numThreads = Runtime.getRuntime().availableProcessors(); // 使用可用处理器数目
        int numTasks = 1000;
        int[] data = new int[numTasks];
        AtomicInteger sum = new AtomicInteger(0);

        for (int i = 0; i < numTasks; i++) {
            data[i] = i + 1;
        }

        ExecutorService executor = Executors.newFixedThreadPool(numThreads);

        for (int i = 0; i < numTasks; i++) {
            int finalI = i;
            executor.submit(() -> {
                int value = data[finalI];
                sum.addAndGet(value);
            });
        }

        executor.shutdown();
        while (!executor.isTerminated()) {
            // 等待所有任务完成
        }

        System.out.println("Sum: " + sum.get());
    }
}
