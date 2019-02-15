package com.foodbird.demo.entity;

import com.foodbird.demo.itf.IdName;
import com.foodbird.generate.dynamic.annotations.FBEntity;

import java.util.List;

/**
 * @author yuyang48
 * @prject com.foodbird.coder
 * @date 2019/1/18
 */
@FBEntity(name = "班级", code = "class")
public class Classes implements IdName {

    private int id;
    private String name;
    private String number;
    private int headmaster;
    private int grade;
    private List<Integer> students;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getHeadmaster() {
        return headmaster;
    }

    public void setHeadmaster(int headmaster) {
        this.headmaster = headmaster;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public List<Integer> getStudents() {
        return students;
    }

    public void setStudents(List<Integer> students) {
        this.students = students;
    }

    @Override
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
