package com.sub.common.gen.tools;

/**
 * Created by yy111026 on 2017/2/9.
 */
public class SystemUtils {

    public static String getSystemUser() {
        return System.getenv().get("USERNAME");
    }

}
