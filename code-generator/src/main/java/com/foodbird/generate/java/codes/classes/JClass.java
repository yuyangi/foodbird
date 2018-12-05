package com.foodbird.generate.java.codes.classes;

import com.foodbird.generate.java.codes.IClass;
import com.foodbird.generate.java.codes.IMethod;

import java.util.List;

/**
 * @author yy111026 on 2017/2/14.
 */
public interface JClass extends IClass {

    List<IMethod> getConstructors();

}
