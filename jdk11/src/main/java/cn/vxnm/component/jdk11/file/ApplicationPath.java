package cn.vxnm.component.jdk11.file;

import java.io.File;

public class ApplicationPath {

    /**
     * 返回当前系统用户根目录
     *
     * Windows C:\Users\{username}
     * Linux /home/{username}
     */
    public static String getSystemUserRootPath() {
        return System.getProperty("user.home");
    }

    /**
     * 获取当前应用根目录
     */
    public static String getApplicationRootPath() {
        File directory = new File("");
       return directory.getAbsolutePath();
    }
}
