package com.sub.gen.meta;

import com.sub.gen.ICoder;
import com.sub.gen.enums.ReferenceForm;
import com.sub.gen.enums.InstanceMode;
import com.sub.gen.enums.ReferenceType;

/**
 * Created by yy111026 on 2017/2/8.
 */
public interface IReference extends ICoder {

    ICodeModel getReference();

    InstanceMode getReferenceInstanceMode();

    IMethod getMethod();

    ReferenceType getReferenceType();

    ReferenceForm getReferenceForm();

}
