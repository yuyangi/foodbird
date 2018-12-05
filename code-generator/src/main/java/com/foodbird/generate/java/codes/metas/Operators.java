package com.foodbird.generate.java.codes.metas;

import com.foodbird.generate.java.codes.IMeta;

/**
 * @author yuyang48
 * @prject com.yy.CodeGen
 * @date 2018/10/29
 */
public enum Operators implements IMeta {

    /** 算数 */
    //+	加法 - 相加运算符两侧的值	A + B 等于 30
    PLUS("+"),
    //-	减法 - 左操作数减去右操作数	A – B 等于 -10
    MINUS("-"),
    //*	乘法 - 相乘操作符两侧的值	A * B等于200
    MULTIPLY("*"),
    ///	除法 - 左操作数除以右操作数	B / A等于2
    DIVIDE("/"),
    //％	取余 - 左操作数除以右操作数的余数	B%A等于0
    MOD("%"),
    //++	自增: 操作数的值增加1	B++ 或 ++B 等于 21（区别详见下文）
    INC("++"),
    //--	自减: 操作数的值减少1	B-- 或 --B 等于 19（区别详见下文）
    DEC("--"),

    /** 关系 */
    //==	检查如果两个操作数的值是否相等，如果相等则条件为真。	（A == B）为假(非真)。
    EQUAL("=="),
    //!=	检查如果两个操作数的值是否相等，如果值不相等则条件为真。	(A != B) 为真。
    NOT_EQUAL("!="),
    //> 	检查左操作数的值是否大于右操作数的值，如果是那么条件为真。	（A> B）非真。
    GREATER_THAN(">"),
    //< 	检查左操作数的值是否小于右操作数的值，如果是那么条件为真。	（A <B）为真。
    LESS_THAN("<"),
    //>=	检查左操作数的值是否大于或等于右操作数的值，如果是那么条件为真。	（A> = B）为假。
    GREATER_THAN_OR_EQUAL(">="),
    //<=	检查左操作数的值是否小于或等于右操作数的值，如果是那么条件为真。	（A <= B）为真。
    LESS_THAN_OR_EQUAL("<="),

    /** 位运算 */
    //＆	如果相对应位都是1，则结果为1，否则为0	（A＆B），得到12，即0000 1100
    BIT_AND("&"),
    //|	如果相对应位都是0，则结果为0，否则为1	（A | B）得到61，即 0011 1101
    BIT_OR("|"),
    //^	如果相对应位值相同，则结果为0，否则为1	（A ^ B）得到49，即 0011 0001
    BIT_XOR("^"),
    //〜	按位取反运算符翻转操作数的每一位，即0变成1，1变成0。	（〜A）得到-61，即1100 0011
    BIT_NOT("~"),
    //<< 	按位左移运算符。左操作数按位左移右操作数指定的位数。	A << 2得到240，即 1111 0000
    LEFT_SHIFT("<<"),
    //>> 	按位右移运算符。左操作数按位右移右操作数指定的位数。	A >> 2得到15即 1111
    RIGHT_SHIFT(">>"),
    //>>> 	按位右移补零操作符。左操作数的值按右操作数指定的位数右移，移动得到的空位以零填充。	A>>>2得到15即0000 1111
    RIGHT_SHIFT_UNSIGNED(">>>"),

    /** 逻辑 */
    //&&	称为逻辑与运算符。当且仅当两个操作数都为真，条件才为真。	（A && B）为假。
    AND("&&"),
    //| |	称为逻辑或操作符。如果任何两个操作数任何一个为真，条件为真。	（A | | B）为真。
    OR("||"),
    //！	称为逻辑非运算符。用来反转操作数的逻辑状态。如果条件为true，则逻辑非运算符将得到false。	！（A && B）为真。
    NOT("!"),

    /** 赋值 */
    //=	简单的赋值运算符，将右操作数的值赋给左侧操作数	C = A + B将把A + B得到的值赋给C
    ASSIGN("="),
    //+ =	加和赋值操作符，它把左操作数和右操作数相加赋值给左操作数	C + = A等价于C = C + A
    ASSIGN_PLUS("+="),
    //- =	减和赋值操作符，它把左操作数和右操作数相减赋值给左操作数	C - = A等价于C = C -A
    ASSIGN_MINUS("-="),
    //* =	乘和赋值操作符，它把左操作数和右操作数相乘赋值给左操作数	C * = A等价于C = C * A
    ASSIGN_MULTIPLY("*="),
    /// =	除和赋值操作符，它把左操作数和右操作数相除赋值给左操作数	C / = A等价于C = C / A
    ASSIGN_DIVIDE("/="),
    //（％）=	取模和赋值操作符，它把左操作数和右操作数取模后赋值给左操作数	C％= A等价于C = C％A
    ASSIGN_MOD("%="),
    //<< =	左移位赋值运算符	C << = 2等价于C = C << 2
    //>> =	右移位赋值运算符	C >> = 2等价于C = C >> 2
    //＆=	按位与赋值运算符	C＆= 2等价于C = C＆2
    //^ =	按位异或赋值操作符	C ^ = 2等价于C = C ^ 2
    //| =	按位或赋值操作符	C | = 2等价于C = C | 2

    /** 条件 A ? B : C */
    CONDITION("{c} ? {v1} : {v2}"),

    /** instanceof */
    INSTANCEOF("instanceof"),
    ;

    private String name;

    Operators(String name) {
        this.name = name;
    }

    @Override
    public String toCode() {
        return name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Operators{" +
                "name='" + name + '\'' +
                '}';
    }

}
