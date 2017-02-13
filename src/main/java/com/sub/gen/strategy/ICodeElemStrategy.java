package com.sub.gen.strategy;

import com.sub.gen.exception.UnsupportedFormException;
import com.sub.gen.meta.ICodeModel;
import com.sub.gen.meta.IParameter;

/**
 * @author yy111026 
 * 2017/2/9.
 */
public interface ICodeElemStrategy {

    String defineForm(ICodeModel model) throws UnsupportedFormException;

    String stateForm(ICodeModel model) throws UnsupportedFormException;

    String invokeForm(ICodeModel model, IParameter... parameters) throws UnsupportedFormException;

    String variableForm(ICodeModel model, String varName) throws UnsupportedFormException;

}

