package com.sub.common.main;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by yy111026 on 2017/2/9.
 */
public class TestVelocity {

    public static void main(String[] args) {
        VelocityEngine ve = new VelocityEngine();
        ve.init();
        //ȡ��velocity��ģ��
        Template t = ve.getTemplate("hellovelocity.vm");
        //ȡ��velocity��������context
        VelocityContext context = new VelocityContext();
        //����������������
        context.put("name", "Liang");
        context.put("date", (new Date()).toString());
        //Ϊ�����չʾ����ǰ����List��ֵ
        List<String> temp = new ArrayList<>();
        temp.add("1");
        temp.add("2");
        context.put("list", temp);
        //�����
        StringWriter writer = new StringWriter();
        //ת�����
        t.merge(context, writer);
        System.out.println(writer.toString());
    }

}
