package cn.vxnm.component.jdk11.concurrent;

import org.junit.Test;

import static org.junit.Assert.*;

public class TaskExecutePoolTest {

    @Test
    public void submit() {
        TaskExecutePool pool = new TaskExecutePool();

        pool.submit(new TaskExecutePool.Task("123"));
        pool.submit(new TaskExecutePool.Task("456"));
    }
}