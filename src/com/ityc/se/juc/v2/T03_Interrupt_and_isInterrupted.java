package com.ityc.se.juc.v2;

import java.util.concurrent.TimeUnit;

/**
 * @Author yuchao
 * @Description 设置标志位 + 查询标志位
 * @Date 2021/12/3 15:47
 **/
public class T03_Interrupt_and_isInterrupted {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(()->{
            while(true) {
                if(Thread.currentThread().isInterrupted()) {
                    System.out.println("Thread is interrupted!");
                    System.out.println(Thread.currentThread().isInterrupted());
                    break;
                }
            }
        });
        t.start();

        TimeUnit.SECONDS.sleep(2);
        t.interrupt();
    }
}
