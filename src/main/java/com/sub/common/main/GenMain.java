package com.sub.common.main;

import com.sub.common.gen.meta.IMethod;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by yy111026 on 2017/1/24.
 */
public class GenMain {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"classpath:com/sub/spring/spring-common.xml"});
        IMethod getter = (IMethod) context.getBean("getter");
        String[] names = context.getBeanNamesForType(IMethod.class);
        for(String name : names) {
            System.out.println(name);
        }
    }

}
