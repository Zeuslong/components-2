package cn.vxnm.component.jdk11.concurrent;

import java.util.concurrent.*;

public class TaskExecutePool {

    private BlockingQueue<Runnable> taskQueue;

    private ExecutorService taskExecutorPool;

    private class Task implements Runnable {

        @Override
        public void run() {
            System.out.println("Hello");
        }
    }

    public TaskExecutePool() {
        this.taskQueue = new LinkedBlockingQueue<>(100);
        taskExecutorPool = new ThreadPoolExecutor(1, 1, 60L, TimeUnit.SECONDS, taskQueue);
    }

    public void submit(Task task) {
        this.taskExecutorPool.submit(task);
    }

}
