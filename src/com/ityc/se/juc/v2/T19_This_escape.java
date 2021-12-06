package com.ityc.se.juc.v2;

import java.io.IOException;

/**
 * @Author yuchao
 * @Description this�������
 * @Date 2021/12/5 15:21
 **/
public class T19_This_escape {

    private int num = 8;

    public T19_This_escape(){
        new Thread(()->{
            System.out.println(this.num);//�п������0
        }).start();
    }

    public static void main(String[] args) throws IOException {
        new T19_This_escape();
        System.in.read();//��֤���߳̽���ǰ�������Ǹ��߳�ִ����
    }

}
