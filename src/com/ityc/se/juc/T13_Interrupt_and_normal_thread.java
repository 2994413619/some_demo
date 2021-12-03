package com.ityc.se.juc;

import java.util.concurrent.TimeUnit;

/**
 * @Author yuchao
 * @Description interrupt比volatile好，线程在wait、sleep也可以打断
 * @Date 2021/12/3 17:29
 **/
public class T13_Interrupt_and_normal_thread {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(()->{
            while(!Thread.interrupted()) {
                System.out.println("go on");
            }
            System.out.println("t end");
        });

        t.start();

        TimeUnit.SECONDS.sleep(1);
        t.interrupt();
    }
}
