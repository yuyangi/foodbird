package com.sub.gen.meta.classes;

import com.sub.gen.meta.IClass;
import com.sub.gen.meta.IMethod;

import java.util.List;

/**
 * @author yy111026 on 2017/2/14.
 */
public interface JClass extends IClass {

    List<IMethod> getConstructors();

}
