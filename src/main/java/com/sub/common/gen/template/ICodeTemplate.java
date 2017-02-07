package com.sub.common.gen.template;

import com.sub.common.gen.ICoder;
import com.sub.common.gen.collection.ICodePackage;

import java.util.List;

public interface ICodeTemplate extends ICoder {

	String getLanguage();

    String suffix();

    String name();

    String code();

    List<ICodePackage> codePackages();

    // 运算符与表达式
    //      算数
    //      赋值
    //      自增(减)
    //      关系(大于小于)
    //      逻辑运算符
    //      位运算
    //      三元运算
    // 数组
    // 流程控制语句(ifelse switch)
    // 循环(for while)
}
