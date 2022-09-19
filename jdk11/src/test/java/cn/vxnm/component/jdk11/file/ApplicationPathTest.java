package cn.vxnm.component.jdk11.file;

import org.junit.Test;

public class ApplicationPathTest {

    @Test
    public void testGetSystemUserRootPath() {
        System.out.println(ApplicationPath.getSystemUserRootPath());
    }

    @Test
    public void testGetApplicationRootPath() {
        System.out.println(ApplicationPath.getApplicationRootPath());
    }

}