package com.sub.gen.codes.classes;

import com.sub.gen.codes.IClass;
import com.sub.gen.codes.IMethod;

import java.util.List;

/**
 * @author yy111026 on 2017/2/14.
 */
public interface JClass extends IClass {

    List<IMethod> getConstructors();

}
