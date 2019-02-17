package com.foodbird.demo.controller;

import com.foodbird.demo.entity.Classes;
import com.foodbird.demo.entity.Student;
import com.foodbird.demo.entity.Teacher;
import com.foodbird.demo.mapper.ActIdUserMapper;
import com.foodbird.demo.service.ClassService;
import com.foodbird.demo.service.RouterTestService;
import com.foodbird.generate.dynamic.FBIService;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Map;

/**
 * @author yuyang48
 * @prject com.foodbird.coder
 * @date 2019/1/18
 */
@RequestMapping("/demo/class")
@Controller
public class ClassController {

    @Autowired
    private FBIService createClass;

    @Autowired
    private ActIdUserMapper mapper;

    @Autowired
    private RouterTestService routerTestService;

    @RequestMapping("create")
    @ResponseBody
    public Object createClass(@RequestParam int id, @RequestParam String className,
                              @RequestParam int stuId, @RequestParam String stuName,
                              @RequestParam int teachId, @RequestParam String teachName) {
        Student stu = new Student();
        stu.setName(stuName);
        stu.setId(stuId);
        Classes cls = new Classes();
        cls.setId(id);
        cls.setName(className);
        Teacher t = new Teacher();
        t.setId(teachId);
        t.setName(teachName);
        ClassParam param = new ClassParam(stu, cls, t);
        try {
            Object process = createClass.process(param);
            return process;
        } catch (Throwable throwable) {
            return throwable;
        }
    }

    @RequestMapping("query")
    @ResponseBody
    public Object query(@RequestParam String id) {
        return mapper.selectByPrimaryKey(id);
    }

    @RequestMapping("method")
    @ResponseBody
    public Object query() {
        Map<String, String> modifiers = Maps.newHashMap();
        Arrays.stream(ClassService.class.getDeclaredMethods()).forEach(m -> modifiers.put(m.toString(), Modifier.toString(m.getModifiers())));
        return modifiers;
    }

    @RequestMapping("router")
    @ResponseBody
    public Object router(@RequestParam String id) {
        return routerTestService.queryTest(id);
    }

    public class ClassParam {
        private Student stu;
        private Classes cls;
        private Teacher tcher;

        public ClassParam(Student stu, Classes cls, Teacher tcher) {
            this.stu = stu;
            this.cls = cls;
            this.tcher = tcher;
        }

        public Student getStu() {
            return stu;
        }

        public void setStu(Student stu) {
            this.stu = stu;
        }

        public Classes getCls() {
            return cls;
        }

        public void setCls(Classes cls) {
            this.cls = cls;
        }

        public Teacher getTcher() {
            return tcher;
        }

        public void setTcher(Teacher tcher) {
            this.tcher = tcher;
        }
    }

}
