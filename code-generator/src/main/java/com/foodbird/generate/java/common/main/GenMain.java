package com.foodbird.generate.java.common.main;

import com.foodbird.generate.java.codes.IAttribute;
import com.foodbird.generate.java.codes.IClass;
import com.foodbird.generate.java.codes.IPackage;
import com.foodbird.generate.java.codes.IType;
import com.foodbird.generate.java.codes.packages.Package;
import com.foodbird.generate.java.codes.attribute.Attribute;
import com.foodbird.generate.java.codes.classes.ClassAdapter;
import com.foodbird.generate.java.codes.classes.Entity;
import com.foodbird.generate.java.codes.type.Type;
import com.foodbird.generate.java.enums.Modifier;
import com.foodbird.generate.java.io.FileCodeWriter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yy111026 on 2017/1/24.
 */
public class GenMain {

    public static void main(String[] args) {
        //ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"classpath:com/sub/spring/spring-common.xml"});
        //IMethod getter = (IMethod) context.getBean("getter");
        genDto();
    }


    public static String genDto() {
        IType typeString = Type.typeOf(String.class);
        IType typeInt = Type.typeOf(Integer.class);

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
        String codes = dto1.toCode();
        try {
            FileCodeWriter.writeWithFileChannel("/Users/yuyang48/Desktop/", dto1.getCode()+".java", codes);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(codes);
        return codes;
    }

}
