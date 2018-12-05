package com.foodbird.generate.java.config;

import com.foodbird.generate.java.ICoder;

public interface CodeConfig extends ICoder {

    /**
     * 语言
     * @return
     */
	String getLanguage();

    /**
     * 文件类型后缀
     * @return
     */
    String suffix();

    /**
     * 名称
     * @return
     */
    String name();

    /**
     * 编码
     * @return
     */
    String code();

    /**
     * 创建(实例化)
     * @return
     */
    String create();

    /**
     * 循环
     * @return
     */
    String loop();

    /**
     * 赋值
     * @return
     */
    String assign();

    /**
     * 调用
     * @return
     */
    String invoke();

    /**
     * 运算
     * @return
     */
    String operation();

    /**
     * 关系运算 (大于小于等于) 的语法格式
     *
     * @return 关系运算相关代码
     */
    String relation();

    /**
     * 定义声明的语法格式
     * 声明变了,声明类,声明数组相关代码格式
     * 生成:
     *      private int a = 0;
     *      public Product product = null;
     *      protect int[] arr;
     * @return 定义声明相关代码
     */
    String define();

    /**
     * 流程控制语句(ifelse switch)
     * 生成 ifelse
     *      if (something) {
     *
     *      } else if (something else) {
     *
     *      } else {
     *
     *      }
     * 生成 switch
     *      switch (x) {
     *          case 1:
     *              // todo something
     *          case 2:
     *              // todo something
     *          default:
     *              break;
     *      }
     * @return 流程控制相关代码
     */
    String flowControl();

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
