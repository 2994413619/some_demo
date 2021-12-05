package com.ityc.se.juc;

/**
 * @Author yuchao
 * @Description ����ִ�е��³�������Ԥ�ϵĲ�һ��
 * @Date 2021/12/5 14:45
 **/
public class T18_NoVisibility {

    private static volatile boolean ready = false;
    private static int number = 0;

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            while (!ready) {
                Thread.yield();
            }
            System.out.println(number);
        });

        t1.start();

        //������û��������ϵ����������ִ�У�����number���0
        number = 42;
        ready = true;

    }

}
