package com.sub.common.main;

import com.sub.common.gen.enums.DataType;
import com.sub.common.gen.enums.Modifier;
import com.sub.common.gen.io.FileCodeWriter;
import com.sub.common.gen.meta.*;
import com.sub.common.gen.meta.Class;
import com.sub.common.gen.meta.Package;
import com.sub.common.gen.meta.classes.Entity;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yy111026 on 2017/1/24.
 */
public class GenMain {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"classpath:com/sub/spring/spring-common.xml"});
        IMethod getter = (IMethod) context.getBean("getter");
        Class classString = new Class();
        classString.setPackages(new Package(String.class.getName().substring(0, String.class.getName().lastIndexOf('.'))));
        Class classInt = new Class();
        classInt.setPackages(new Package(Integer.class.getName().substring(0, String.class.getName().lastIndexOf('.'))));
        classString.setCode("String");
        classInt.setCode("Integer");
        Type typeString = new Type();
        Type typeInt = new Type();
        typeString.setType(DataType.CLASS);
        typeString.setClassType(classString);
        typeInt.setType(DataType.CLASS);
        typeInt.setClassType(classInt);

        IPackage packages = new Package("com.sub.test.business");

        Entity dto1 = new Entity();
        dto1.setCode("Product");
        dto1.setName("产品");
        dto1.setPackages(packages);
        List<IAttribute> attrs = new ArrayList<>();
        Attribute attr1 = new Attribute();
        attr1.setCode("code");
        attr1.setName("编码");
        attr1.setType(typeString);
        attr1.setVisibility(Modifier.PRIVATE);
        attr1.setParent(dto1);

        Attribute attr2 = new Attribute();
        attr2.setCode("name");
        attr2.setName("名称");
        attr2.setType(typeString);
        attr2.setVisibility(Modifier.PRIVATE);
        attr2.setParent(dto1);

        Attribute attr3 = new Attribute();
        attr3.setCode("id");
        attr3.setName("id");
        attr3.setType(typeInt);
        attr3.setVisibility(Modifier.PRIVATE);
        attr3.setParent(dto1);

        Attribute attr4 = new Attribute();
        attr4.setCode("price");
        attr4.setName("价格");
        attr4.setType(typeInt);
        attr4.setVisibility(Modifier.PRIVATE);
        attr4.setParent(dto1);

        attrs.add(attr1);
        attrs.add(attr2);
        attrs.add(attr3);
        attrs.add(attr4);

        dto1.setAttributes(attrs);

        try {
            FileCodeWriter.writeWithFileChannel("/Users/yy111026/", dto1.getCode()+".java", dto1.toCode());
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(dto1.toCode());
    }

}
