package com.sub.common.gen.strategy;

import com.sub.common.gen.ICoder;

/**
 * Created by yy111026 on 2017/2/9.
 */
public interface ICodeElemStrategy extends ICoder {

    String defineForm();

    String stateForm();

    String invokeForm();

    String variableForm();

}

