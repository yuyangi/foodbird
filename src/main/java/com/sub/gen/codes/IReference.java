package com.sub.gen.codes;

import com.sub.gen.enums.InstanceMode;
import com.sub.gen.enums.ReferenceForm;
import com.sub.gen.enums.ReferenceType;

/**
 * Created by yy111026 on 2017/2/8.
 */
public interface IReference extends ICodeModel {

    IClass getReference();

    InstanceMode getReferenceInstanceMode();

    IMethod getMethod();

    ReferenceType getReferenceType();

    ReferenceForm getReferenceForm();

    String getReturnName();

    void setReturnName(String returnName);

}
