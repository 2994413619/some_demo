package com.ityc.se.juc.v1;

import java.io.IOException;

/**
 * @Author yuchao
 * @Description �������յ�ʱ������finalize()
 *              ������д��Ϊ�˹۲�ʲôʱ�����
 * @Date 2021/12/20 13:52
 **/
public class T25_Hello_finalize {

    @Override
    protected void finalize() throws Throwable {
        System.out.println("finalize");
    }

    public static void main(String[] args) throws IOException {

        //new һ����������������ǿ����
        T25_Hello_finalize instance = new T25_Hello_finalize();
        instance = null;
        System.gc();
        System.in.read();//����main �̣߳���Ϊgc()�ڱ���߳�ִ�У�main����һ�ж�������
    }

}
