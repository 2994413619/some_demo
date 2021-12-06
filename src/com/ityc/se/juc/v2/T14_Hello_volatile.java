package com.ityc.se.juc.v2;

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

/**
 * volatile 关键字，使一个变量在多个线程间可见
 * A B线程都用到一个变量，java默认是A线程中保留一份copy，这样如果B线程修改了该变量，则A线程未必知道
 * 使用volatile关键字，会让所有线程都会读到变量的修改值
 *
 * 在下面的代码中，running是存在于堆内存的t对象中
 * 当线程t1开始运行的时候，会把running值从内存中读到t1线程的工作区，在运行过程中直接使用这个copy，并不会每次都去
 * 读取堆内存，这样，当主线程修改running的值之后，t1线程感知不到，所以不会停止运行
 *
 * 使用volatile，将会强制所有线程都去堆内存中读取running的值
 *
 * 可以阅读这篇文章进行更深入的理解
 * http://www.cnblogs.com/nexiyi/p/java_memory_model_and_thread.html
 *
 * volatile并不能保证多个线程共同修改running变量时所带来的不一致问题，也就是说volatile不能替代synchronized
 **/