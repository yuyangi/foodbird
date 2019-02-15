package com.foodbird.demo.service;

import com.foodbird.demo.datasource.Storage;
import com.foodbird.demo.entity.Classes;
import com.foodbird.generate.dynamic.annotations.FBAction;
import com.foodbird.generate.dynamic.annotations.FBOperation;
import com.foodbird.generate.dynamic.annotations.FBProcess;
import com.foodbird.generate.dynamic.annotations.FBService;

/**
 * @author yuyang48
 * @prject com.foodbird.coder
 * @date 2019/1/18
 */
@FBService(name = "班级业务处理服务", code = "class service")
@FBProcess(id = "createClass")
public class ClassService extends BaseService<Classes> {

    @Override
    @FBOperation(name = "查询", code = "query")
    public Classes read(int id) {
        return super.read(id);
    }

    @Override
    @FBOperation(name = "创建", code = "create")
    @FBAction(id = "createClass", serviceId = "createClass",dependencies = {"createStudent, createTeacher"})
    public void create(Classes aClass) {
        super.create(aClass);
    }

    @Override
    @FBOperation(name = "更新", code = "update")
    public void update(Classes aClass) {
        super.update(aClass);
    }

    @Override
    public void delete(Classes aClass) {
        super.delete(aClass);
    }

    @Override
    public Class<Classes> storageType() {
        return Classes.class;
    }
}
