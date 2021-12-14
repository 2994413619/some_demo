package com.ityc.se.juc.interview;

import java.util.concurrent.Semaphore;

/**
 * @Author yuchao
 * @Description 两个线程交替打印A-Z、1-26
 *              使用notify()和wait()
 * @Date 2021/12/14 17:56
 **/
public class T08_Interview02_printA_Z_and_1_26 {

    public static void main(String[] args) {

        Object obj = new Object();

        Thread t1 = new Thread(()->{
            synchronized (obj) {
                for(int i = 1; i <= 26; i++) {
                    System.out.println("t1-" + i);
                    obj.notify();

                    if(i == 26){
                        break;
                    }

                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        });
        Thread t2 = new Thread(()->{
            synchronized (obj) {
                for (int i = 0; i < 26; i++) {
                    System.out.println("t2-" + (char) ('A' + i));
                    obj.notify();

                    if(i == 25){
                        break;
                    }

                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        t1.start();
        t2.start();

    }

}
