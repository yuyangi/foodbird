package com.sub.common.gen.template;

import com.sub.common.gen.ICoder;
import com.sub.common.gen.collection.ICodePackage;

import java.util.List;

public interface ICodeTemplate extends ICoder {

    /**
     * ����
     * @return
     */
	String getLanguage();

    /**
     * �ļ����ͺ�׺
     * @return
     */
    String suffix();

    /**
     * ����
     * @return
     */
    String name();

    /**
     * ����
     * @return
     */
    String code();

    /**
     * ����(ʵ����)
     * @return
     */
    String create();

    /**
     * ѭ��
     * @return
     */
    String loop();

    /**
     * ��ֵ
     * @return
     */
    String assign();

    /**
     * ����
     * @return
     */
    String invoke();

    /**
     * ����
     * @return
     */
    String operation();

    /**
     * ��ϵ���� (����С�ڵ���) ���﷨��ʽ
     *
     * @return ��ϵ������ش���
     */
    String relation();

    /**
     * �����������﷨��ʽ
     * ��������,������,����������ش����ʽ
     * ����:
     *      private int a = 0;
     *      public Product product = null;
     *      protect int[] arr;
     * @return ����������ش���
     */
    String define();

    /**
     * ���̿������(ifelse switch)
     * ���� ifelse
     *      if (something) {
     *
     *      } else if (something else) {
     *
     *      } else {
     *
     *      }
     * ���� switch
     *      switch (x) {
     *          case 1:
     *              // todo something
     *          case 2:
     *              // todo something
     *          default:
     *              break;
     *      }
     * @return ���̿�����ش���
     */
    String flowControl();

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
