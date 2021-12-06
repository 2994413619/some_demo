package com.ityc.se.juc.v2;

import java.util.concurrent.TimeUnit;

/**
 * @Author yuchao
 * @Description sleep、wait、join的时候，调用interrupted，线程会抛出InterruptedException,catch异常后，标志位会复位。
 * @Date 2021/12/3 16:08
 **/
public class T05_Interrupt_and_sleep {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(()->{
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                System.out.println("Thread is interrupted!");
                System.out.println(Thread.currentThread().isInterrupted());
                e.printStackTrace();
            }
        });
        t.start();

        TimeUnit.SECONDS.sleep(5);
        t.interrupt();
    }
}
