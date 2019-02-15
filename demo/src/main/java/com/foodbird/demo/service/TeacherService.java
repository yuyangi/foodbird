package com.foodbird.demo.service;

import com.foodbird.demo.entity.Teacher;
import com.foodbird.generate.dynamic.annotations.FBAction;
import com.foodbird.generate.dynamic.annotations.FBOperation;
import com.foodbird.generate.dynamic.annotations.FBProcess;
import com.foodbird.generate.dynamic.annotations.FBService;

/**
 * @author yuyang48
 * @prject com.foodbird.coder
 * @date 2019/1/18
 */
@FBService(name = "教师业务处理服务", code = "teacher")
@FBProcess(id = "createClass")
public class TeacherService extends BaseService<Teacher> {

    @Override
    @FBOperation(name = "查询", code = "query")
    public Teacher read(int id) {
        return super.read(id);
    }

    @Override
    @FBOperation(name = "创建", code = "create")
    @FBAction(id = "createTeacher", serviceId = "createClass")
    public void create(Teacher teacher) {
        super.create(teacher);
    }

    @Override
    @FBOperation(name = "更新", code = "update")
    public void update(Teacher teacher) {
        super.update(teacher);
    }

    @Override
    @FBOperation(name = "删除", code = "delete")
    public void delete(Teacher teacher) {
        super.delete(teacher);
    }

    @Override
    public Class<Teacher> storageType() {
        return Teacher.class;
    }
}
