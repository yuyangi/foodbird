package com.sub.common.gen.template;

import java.util.List;

import com.sub.common.gen.model.IClass;
import com.sub.common.gen.model.ICoder;
import com.sub.common.gen.model.IMethod;
import com.sub.common.gen.model.ICodeModel;

public interface ICodeTemplate extends ICoder {

	String getLanguage();

	String getModule();

    String getLevel();

	List<ICoder> getCoders();

	void generate();

}
