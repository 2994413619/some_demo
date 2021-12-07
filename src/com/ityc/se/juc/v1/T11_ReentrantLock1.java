package com.ityc.se.juc.v1;

import java.util.concurrent.TimeUnit;

/**
 * @Author yuchao
 * @Description 演示synchronized的可重入,ReentrantLock可以替代synchronized
 * @Date 2021/12/7 14:37
 **/
public class T11_ReentrantLock1 {
    synchronized void m1() {
        for(int i=0; i<10; i++) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i);
            if(i == 2) m2();
        }

    }

    synchronized void m2() {
        System.out.println("m2 ...");
    }

    public static void main(String[] args) {
        T11_ReentrantLock1 rl = new T11_ReentrantLock1();
        new Thread(rl::m1).start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //new Thread(rl::m2).start();
    }
}
