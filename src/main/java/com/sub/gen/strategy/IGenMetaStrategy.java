package com.sub.gen.strategy;

import com.sub.gen.exception.UnsupportedFormException;
import com.sub.gen.meta.ICodeModel;
import com.sub.gen.meta.IParameter;

/**
 * @author yy111026 
 * 2017/2/9.
 */
public interface IGenMetaStrategy {

    /**
     * 生成定义模式代码
     * @param model
     * @return
     * @throws UnsupportedFormException
     */
    String defineForm(ICodeModel model) throws UnsupportedFormException;

    /**
     * 生成一般模式代码
     * @param model
     * @return
     * @throws UnsupportedFormException
     */
    String stateForm(ICodeModel model) throws UnsupportedFormException;

    /**
     * 生成调用模式diam
     * @param model
     * @param parameters
     * @return
     * @throws UnsupportedFormException
     */
    String invokeForm(ICodeModel model, IParameter... parameters) throws UnsupportedFormException;

    /**
     * 生成变量模式代码
     * @param model
     * @param varName
     * @return
     * @throws UnsupportedFormException
     */
    String variableForm(ICodeModel model, String varName) throws UnsupportedFormException;

}
