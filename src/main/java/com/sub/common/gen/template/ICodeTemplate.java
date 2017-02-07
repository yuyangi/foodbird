package com.sub.common.gen.template;

import com.sub.common.gen.ICoder;
import com.sub.common.gen.collection.ICodePackage;

import java.util.List;

public interface ICodeTemplate extends ICoder {

	String getLanguage();

    String suffix();

    String name();

    String code();

    List<ICodePackage> codePackages();

    // ���������ʽ
    //      ����
    //      ��ֵ
    //      ����(��)
    //      ��ϵ(����С��)
    //      �߼������
    //      λ����
    //      ��Ԫ����
    // ����
    // ���̿������(ifelse switch)
    // ѭ��(for while)
}
