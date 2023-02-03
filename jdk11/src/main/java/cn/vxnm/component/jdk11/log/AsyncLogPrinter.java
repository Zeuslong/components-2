package cn.vxnm.component.jdk11.log;

import java.util.concurrent.*;
import java.util.logging.Logger;

public class AsyncLogPrinter {

    private final Logger logger;

    private final BlockingQueue<Runnable> taskQueue;

    private final ExecutorService taskExecutorPool;

    public AsyncLogPrinter(Logger logger) {
        this.logger = logger;
        this.taskQueue = new LinkedBlockingQueue<>();
        this.taskExecutorPool = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, taskQueue);
    }

    private void submit(Runnable runnable) {
        this.taskExecutorPool.submit(runnable);
    }

    public void info(String message) {
        submit(() -> logger.info(message));
    }

    public void warning(String message) {
        submit(() -> logger.warning(message));
    }
}
