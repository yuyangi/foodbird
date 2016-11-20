package com.sub.biz.gen.template;

import java.util.List;

import com.sub.biz.gen.model.IEntity;
import com.sub.biz.gen.model.IMethod;
import com.sub.biz.gen.model.ICodeModel;

public interface ICodeTemplate extends ICodeModel {

	String language();

	String level();

	IEntity entitiy();

	List<IMethod> methods();

}
