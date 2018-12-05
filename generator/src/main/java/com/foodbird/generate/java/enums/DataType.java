package com.foodbird.generate.java.enums;

/**
 * Created by yuyang on 2016/11/26.
 */
public enum DataType {

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

    public static DataType[] Basics = new DataType[] {BYTE, SHORT,INT,LONG,CHAR,FLOAT,DOUBLE,BOOLEAN};
    public static DataType[] Objects = new DataType[] {CLASS,LIST,MAP,ARRAY};

}
