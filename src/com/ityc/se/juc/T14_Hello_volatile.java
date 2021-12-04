package com.ityc.se.juc;

import java.util.concurrent.TimeUnit;

/**
 * @Author yuchao
 * @Description 使用volatile是变量线程见可见
 * @Date 2021/12/4 22:00
 **/
public class T14_Hello_volatile {

    private static /*volatile*/ boolean running = true;

    private static void m(){
        System.out.println("m start!");
        while(running) {
            System.out.println("hello");//println使用了synchronized，会触发内存缓存同步刷新
        }
        System.out.println("m end!");
    }

    public static void main(String[] args) throws InterruptedException {
        new Thread(T14_Hello_volatile::m, "t1").start();

        TimeUnit.SECONDS.sleep(1);

        running = false;
    }


}
