package com.ityc.se.juc.v1;

import java.util.ArrayList;

/**
 * @Author yuchao
 * @Description volatile���ܱ�֤ԭ����
 *              volatile�����ܱ�֤����̹߳�ͬ�޸�count����ʱ�������Ĳ�һ�����⣬Ҳ����˵volatile�������synchronized
 * @Date 2021/12/6 15:17
 **/
public class T07_volatile_not_atomicity {

    private volatile int count = 0;

    private void m(){
        for(int i = 0; i < 10000; i++) {
            count++;
        }
    }

    public static void main(String[] args) {
        T07_volatile_not_atomicity instance = new T07_volatile_not_atomicity();
        ArrayList<Thread> list = new ArrayList<>();
        for(int i = 0; i < 10; i++) {
            list.add(new Thread(instance::m, "Thread-" + i));
        }

        list.forEach((o)->{o.start();});
        list.forEach((o)->{
            try {
                o.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.println(instance.count);
    }

}
