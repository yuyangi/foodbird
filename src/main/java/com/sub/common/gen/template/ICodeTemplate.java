package com.sub.common.gen.template;

import java.util.List;

import com.sub.common.gen.model.IClass;
import com.sub.common.gen.model.ICoder;
import com.sub.common.gen.model.IMethod;
import com.sub.common.gen.model.ICodeModel;

public interface ICodeTemplate extends ICodeModel, ICoder {

	String language();

	String level();

	IClass entitiy();

	List<IMethod> methods();

}
