package com.foodbird.demo.service;

import com.foodbird.demo.entity.Student;
import com.foodbird.generate.dynamic.annotations.FBAction;
import com.foodbird.generate.dynamic.annotations.FBOperation;
import com.foodbird.generate.dynamic.annotations.FBProcess;
import com.foodbird.generate.dynamic.annotations.FBService;

/**
 * @author yuyang48
 * @prject com.foodbird.coder
 * @date 2019/1/18
 */
@FBService(name = "学生业务处理服务", code = "student service")
@FBProcess(id = "createClass")
public class StudentService extends BaseService<Student> {

    @Override
    @FBOperation(name = "查询", code = "query")
    public Student read(int id) {
        return super.read(id);
    }

    @Override
    @FBOperation(name = "创建", code = "create")
    @FBAction(id = "createStudent", serviceId = "createClass")
    public void create(Student student) {
        super.create(student);
    }

    @Override
    @FBOperation(name = "更新", code = "update")
    public void update(Student student) {
        super.update(student);
    }

    @Override
    @FBOperation(name = "删除", code = "delete")
    public void delete(Student student) {
        super.delete(student);
    }

    @Override
    public Class<Student> storageType() {
        return Student.class;
    }
}
