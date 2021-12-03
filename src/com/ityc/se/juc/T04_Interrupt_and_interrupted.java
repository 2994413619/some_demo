package com.ityc.se.juc;

import java.util.concurrent.TimeUnit;

/**
 * @Author yuchao
 * @Description 打断线程，并调用Thread.interrupted()查看效果
 * @Date 2021/12/3 16:02
 **/
public class T04_Interrupt_and_interrupted {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(()->{
            while(true) {
                if(Thread.interrupted()) {
                    System.out.println("Thread is interrupted!");
                    System.out.println(Thread.interrupted());
                    break;
                }
            }
        });
        t.start();

        TimeUnit.SECONDS.sleep(2);
        t.interrupt();

        System.out.println("main:" + t.interrupted());//虽然是t调用，但是因为是静态方法，其实执行的还是Thread.interrupted()
    }
}
