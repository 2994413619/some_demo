package com.ityc.se.juc;

import java.util.concurrent.TimeUnit;

/**
 * @Author yuchao
 * @Description interrupt 和 wait
 * @Date 2021/12/3 16:16
 **/
public class T06_Interrupt_and_wait {
    public static void main(String[] args) throws InterruptedException {
        Object o = new Object();
        Thread t = new Thread(()->{
            synchronized (o) {
                try {
                    o.wait();
                } catch (InterruptedException e) {
                    System.out.println("Thread is interrupted!");
                    System.out.println(Thread.currentThread().isInterrupted());
                    e.printStackTrace();
                }
            }
        });
        t.start();

        TimeUnit.SECONDS.sleep(5);
        t.interrupt();
    }
}
