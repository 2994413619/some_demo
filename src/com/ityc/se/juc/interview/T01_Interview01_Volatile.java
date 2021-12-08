package com.ityc.se.juc.interview;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Author yuchao
 * @Description �����������⣺���Ա�����
 *              ʵ��һ���������ṩ����������add��size
 *              д�����̣߳��߳�1���10��Ԫ�ص������У��߳�2ʵ�ּ��Ԫ�صĸ�������������5��ʱ���߳�2������ʾ������
 *
 *              �����������������������������
 * @Date 2021/12/8 9:40
 **/
public class T01_Interview01_Volatile {

    //���1����ʹ��volatile
    //List lists = new ArrayList();

    //���2��ʹ��volatile
    //volatile List lists = new ArrayList();

    //���3��
    volatile List<Object> lists = Collections.synchronizedList(new LinkedList<>());

    public void add(Object o) {
        lists.add(o);
    }

    public int size() {
        return lists.size();
    }

    public static void main(String[] args) {
        T01_Interview01_Volatile c = new T01_Interview01_Volatile();

        new Thread(() -> {
            for(int i=0; i<10; i++) {
                c.add(new Object());
                System.out.println("add " + i);

                //�Ӳ���sleep,�����̫һ��
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "t1").start();

        new Thread(() -> {
            while(true) {
                if(c.size() == 5) {//����list���Ѿ���5���ˣ�����size����4����Ϊ���Ԫ�غ�size++����������������ԭ�ӵ�
                    break;
                }
            }
            System.out.println("t2 ����");
        }, "t2").start();
    }

}
