package com.ityc.se.juc.v1;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @Author yuchao
 * @Description 有界队列
 * @Date 2021/12/21 10:49
 **/
public class T42_ArrayBlockingQueue {

    static BlockingQueue<String> strs = new ArrayBlockingQueue<>(10);

    static Random r = new Random();

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            strs.put("a" + i);
        }

        //strs.put("aaa"); //满了就会等待，程序阻塞
        //strs.add("aaa");//满了add会抛异常
        //strs.offer("aaa");//满了，会返回false表示添加失败
        strs.offer("aaa", 1, TimeUnit.SECONDS);//阻塞一秒后失败

        System.out.println(strs);
    }

}
