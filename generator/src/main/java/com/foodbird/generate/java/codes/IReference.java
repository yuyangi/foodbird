package com.foodbird.generate.java.codes;

import com.foodbird.generate.java.enums.InstanceMode;
import com.foodbird.generate.java.enums.ReferenceForm;
import com.foodbird.generate.java.enums.ReferenceType;

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
