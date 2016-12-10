package com.sub.common.gen.enums;

/**
 * Created by yuyang on 2016/11/26.
 */
public enum Type {

    BYTE,
    SHORT,
    INT,
    LONG,
    CHAR,
    FLOAT,
    DOUBLE,
    BOOLEAN,
    CLASS,
    LIST,
    MAP,
    ARRAY,
    NULL,
    VOID;

    public static Type[] Basics = new Type[] {BYTE, SHORT,INT,LONG,CHAR,FLOAT,DOUBLE,BOOLEAN};
    public static Type[] Objects = new Type[] {CLASS,LIST,MAP,ARRAY};

}
