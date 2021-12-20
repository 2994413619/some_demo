package com.ityc.se.juc.v1;

import java.util.concurrent.TimeUnit;

/**
 * @Author yuchao
 * @Description ����ThreadLocal��������ͨ���ó����ThreadLocalԴ��
 * @Date 2021/12/20 11:30
 **/
public class T24_Hello_ThreadLocal {
    //volatile static Person p = new Person();
    static ThreadLocal<Person> tl = new ThreadLocal<>();

    public static void main(String[] args) {

        //˯��2���ȡtl�е�ֵ
        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(tl.get());
        }).start();

        //˯��1���tl�з���һ��person
        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            tl.set(new Person());
        }).start();
    }

    static class Person {
        String name = "zhangsan";
    }
}