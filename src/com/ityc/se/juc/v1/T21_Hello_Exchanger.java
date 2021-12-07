package com.ityc.se.juc.v1;

import java.util.concurrent.Exchanger;

/**
 * @Author yuchao
 * @Description 演示Exchanger，两个线程间交换对象
 * @Date 2021/12/7 17:13
 **/
public class T21_Hello_Exchanger {

    static Exchanger<String> exchanger = new Exchanger<>();

    public static void main(String[] args) {
        new Thread(()->{
            String s = "T1";
            try {
                s = exchanger.exchange(s);//阻塞方法
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " " + s);

        }, "t1").start();


        new Thread(()->{
            String s = "T2";
            try {
                s = exchanger.exchange(s);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " " + s);

        }, "t2").start();


    }

}
