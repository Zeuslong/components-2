package cn.vxnm.component.jdk11.log;

import java.util.concurrent.*;

public class AsyncLogPrinter {

    private final BlockingQueue<Runnable> taskQueue;

    private final ExecutorService taskExecutorPool;

    public AsyncLogPrinter() {
        this.taskQueue = new LinkedBlockingQueue<Runnable>();
        this.taskExecutorPool = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, taskQueue);
    }

    public void submit(Runnable runnable) {
        this.taskExecutorPool.submit(runnable);
    }
}
