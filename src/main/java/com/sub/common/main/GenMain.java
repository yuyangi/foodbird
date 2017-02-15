package com.sub.common.main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.sub.gen.enums.DataType;
import com.sub.gen.enums.Modifier;
import com.sub.gen.io.FileCodeWriter;
import com.sub.gen.meta.IAttribute;
import com.sub.gen.meta.IClass;
import com.sub.gen.meta.IPackage;
import com.sub.gen.meta.attribute.Attribute;
import com.sub.gen.meta.classes.ClassAdapter;
import com.sub.gen.meta.classes.Entity;
import com.sub.gen.meta.packages.Package;
import com.sub.gen.meta.type.Type;

/**
 * @author yy111026 on 2017/1/24.
 */
public class GenMain {

    public static void main(String[] args) {
        //ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"classpath:com/sub/spring/spring-common.xml"});
        //IMethod getter = (IMethod) context.getBean("getter");
        IClass ClassString = new ClassAdapter(String.class);
        IClass ClassInt = new ClassAdapter(Integer.class);
        Type typeString = new Type();
        Type typeInt = new Type();
        typeString.setType(DataType.CLASS);
        typeString.setClassType(ClassString);
        typeInt.setType(DataType.CLASS);
        typeInt.setClassType(ClassInt);

        IPackage packages = new Package("com.sub.test.business");

        Entity dto1 = new Entity();
        dto1.setCode("Product");
        dto1.setName("��Ʒ");
        dto1.setPackages(packages);
        List<IAttribute> attrs = new ArrayList<>();
        Attribute attr1 = new Attribute();
        attr1.setCode("code");
        attr1.setName("����");
        attr1.setType(typeString);
        attr1.setVisibility(Modifier.PRIVATE);
        attr1.setParent(dto1);

        Attribute attr2 = new Attribute();
        attr2.setCode("name");
        attr2.setName("����");
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
        attr4.setName("�۸�");
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
