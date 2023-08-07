package com.systeminfos.design.pattern.Parallel;

import java.util.concurrent.RecursiveTask;
import java.util.concurrent.ForkJoinPool;

class RecursiveSumTask extends RecursiveTask<Integer> {
    private static final int THRESHOLD = 10;
    private int[] array;
    private int start;
    private int end;

    public RecursiveSumTask(int[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        if (end - start <= THRESHOLD) {
            int sum = 0;
            for (int i = start; i < end; i++) {
                sum += array[i];
            }
            return sum;
        } else {
            int mid = (start + end) / 2;
            RecursiveSumTask leftTask = new RecursiveSumTask(array, start, mid);
            RecursiveSumTask rightTask = new RecursiveSumTask(array, mid, end);

            leftTask.fork();
            int rightResult = rightTask.compute();
            int leftResult = leftTask.join();

            return leftResult + rightResult;
        }
    }
}

/**
 * Fork-Join 模式：将一个任务拆分成多个子任务，并行执行，然后将子任务的结果合并。
 */
public class ForkJoinExample {
    public static void main(String[] args) {
        int[] array = new int[1000];
        for (int i = 0; i < 1000; i++) {
            array[i] = i + 1;
        }

        ForkJoinPool pool = new ForkJoinPool();
        RecursiveSumTask task = new RecursiveSumTask(array, 0, array.length);

        int result = pool.invoke(task);

        System.out.println("Sum: " + result);
    }
}
