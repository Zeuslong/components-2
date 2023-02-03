package cn.vxnm.component.jdk11.log;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.logging.Logger;

import static org.junit.Assert.*;

public class AsyncLogPrinterTest {

    Logger logger = Logger.getLogger(AsyncLogPrinterTest.class.getName());

    AsyncLogPrinter printer = new AsyncLogPrinter(logger);

    @Test
    public void info() {
        printer.info("Hello info!");
    }

    @Test
    public void warning() {
        printer.warning("Hello warning!");
    }

}