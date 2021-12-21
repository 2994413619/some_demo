package com.ityc.se.juc.interview;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

/**
 * @Author yuchao
 * @Description 两个线程交替打印A-Z、1-26
 *              使用notify()和wait()
 * @Date 2021/12/14 17:56
 **/
public class T10_Interview03_printA1B2_sync_wait_notify {

    static List<Integer> intList;
    static List<Character> strList;

    static {
        intList = new ArrayList<>();
        strList = new ArrayList<>();
        for(int i = 0; i < 26; i++) {
            intList.add(i + 1);
            strList.add((char) ('A' + i));
        }
    }


    public static void main(String[] args) {

        final Object obj = new Object();

        Thread t1 = new Thread(()->{
            synchronized (obj) {
                for(int i : intList) {
                    System.out.print(i + " ");
                    obj.notify();

                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                obj.notify();//防止最后程序未退出
            }

        });
        Thread t2 = new Thread(()->{
            synchronized (obj) {
                for (char i : strList) {
                    System.out.print(i + " ");
                    obj.notify();

                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                obj.notify();//防止最后程序未退出
            }
        });

        t1.start();
        t2.start();

    }

}
