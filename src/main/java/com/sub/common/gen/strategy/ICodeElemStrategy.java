package com.sub.common.gen.strategy;

import com.sub.common.gen.exception.UnsupportedFormException;
import com.sub.common.gen.meta.IParameter;

/**
 * Created by yy111026 on 2017/2/9.
 */
public interface ICodeElemStrategy {

    String defineForm() throws UnsupportedFormException;

    String stateForm() throws UnsupportedFormException;

    String invokeForm(IParameter... parameters) throws UnsupportedFormException;

    String variableForm(String varName) throws UnsupportedFormException;

}

