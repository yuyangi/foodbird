package com.sub.gen.meta;

import com.sub.gen.ICoder;
import com.sub.gen.enums.ReferenceForm;
import com.sub.gen.enums.InstanceMode;
import com.sub.gen.enums.ReferenceType;

import java.util.List;

/**
 * Created by yy111026 on 2017/2/8.
 */
public interface IReference extends ICodeModel {

    ICodeModel getReference();

    InstanceMode getReferenceInstanceMode();

    IMethod getMethod();

    ReferenceType getReferenceType();

    ReferenceForm getReferenceForm();

    List<IReference> getDependencies();

}
