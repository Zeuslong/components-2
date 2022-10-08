package cn.vxnm.component.jdk11.concurrent;

import java.util.concurrent.*;

public class TaskExecutePool {

    private final BlockingQueue<Runnable> taskQueue;

    private final ExecutorService taskExecutorPool;

    static class Task implements Runnable {

        private volatile String name;

        public Task(String name) {
            setName(name);
        }

        public synchronized String getName() {
            return name;
        }

        public synchronized void setName(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            System.out.println(getName());
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
