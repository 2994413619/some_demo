package com.ityc.se.juc.v1;

import java.util.concurrent.TimeUnit;

/**
 * @Author yuchao
 * @Description ����ĳ����o�����o�����Է����ı䣬��Ӱ������ʹ��
 *              �������o�������һ�������������Ķ������ı�
 *              Ӧ�ñ��⽫������������ñ������Ķ���
 * @Date 2021/12/6 15:28
 **/
public class T08_Sync_same_object {
    /*final*/ Object o = new Object();

    void m() {
        synchronized(o) {
            while(true) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());


            }
        }
    }

    public static void main(String[] args) {
        T08_Sync_same_object t = new T08_Sync_same_object();
        //������һ���߳�
        new Thread(t::m, "t1").start();

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //�����ڶ����߳�
        Thread t2 = new Thread(t::m, "t2");

        t.o = new Object(); //���������ı䣬����t2�̵߳���ִ�У����ע�͵���仰���߳�2����Զ�ò���ִ�л���

        t2.start();

    }
}
