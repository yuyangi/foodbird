package com.sub.common.gen.tools;

/**
 * Created by yy111026 on 2016/12/9.
 */
public class NameUtils {

    public static String getVarName(String entityName) {
        return entityName.substring(0, 1).toLowerCase() + entityName.substring(1);
    }

}
