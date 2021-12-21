package com.ityc.se.juc.v1;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * @Author yuchao
 * @Description 线程间传单个任务；容量为0；一
 *              个线程put()，另一个线程take()。两个均为阻塞方法，也就是说如果没有线程take()，那么put()会一致阻塞，反之亦然。
 *              自己实现线程池常用。
 * @Date 2021/12/21 11:07
 **/
public class T45_SynchronusQueue { //容量为0

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> strs = new SynchronousQueue<>();

        new Thread(()->{
            try {
                System.out.println(strs.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        strs.put("aaa"); //阻塞等待消费者消费
        //strs.put("bbb");
        //strs.add("aaa");
        System.out.println(strs.size());
    }

}
