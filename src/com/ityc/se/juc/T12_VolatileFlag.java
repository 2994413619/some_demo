package com.ityc.se.juc;

import java.util.concurrent.TimeUnit;

/**
 * @Author yuchao
 * @Description 使用volatile停止线程
 * @Date 2021/12/3 17:23
 **/
public class T12_VolatileFlag {

    private static volatile  boolean running = true;

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(()->{
            long i = 0L;
            while(running) {
                i++;//如果这里有wait、sleep,会导致在此期间不能结束线程
            }
            System.out.println("end and i = " + i);//2450926705  2514807069  跑两次结果不一致
        });

        t.start();

        TimeUnit.SECONDS.sleep(1);
        running = false;
    }

}
