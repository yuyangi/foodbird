package com.sub.biz.gen.model;

import java.util.List;

public interface IEntity extends ICodeModel {

	List<IAttribute> attributes();

	String visibility();

}
