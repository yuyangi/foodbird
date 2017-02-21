package com.sub.gen.strategy;

import com.sub.gen.exception.UnsupportedFormException;
import com.sub.gen.meta.ICodeModel;

/**
 * Created by yy111026 on 2017/2/9.
 */
public interface IGenFormStrategy {

    String generate(ICodeModel model) throws UnsupportedFormException;

}
