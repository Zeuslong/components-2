package cn.vxnm.component.jdk11.log;

import org.junit.Test;

import java.util.logging.Logger;

import static org.junit.Assert.*;

public class AsyncLogPrinterTest {

    Logger logger = Logger.getLogger(AsyncLogPrinterTest.class.getName());

    AsyncLogPrinter printer = new AsyncLogPrinter();

    @Test
    public void submit() {
        printer.submit(() -> logger.info("Hello world"));
    }
}