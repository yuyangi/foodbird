package com.foodbird.demo.entity;

import com.foodbird.demo.itf.IdName;
import com.foodbird.generate.dynamic.annotations.FBEntity;

/**
 * @author yuyang48
 * @prject com.foodbird.coder
 * @date 2019/1/18
 */
@FBEntity(name = "学生", code = "student")
public class Student implements IdName {

    private String name;
    private int id;
    private int gender;
    private int age;
    private int classId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }
}
