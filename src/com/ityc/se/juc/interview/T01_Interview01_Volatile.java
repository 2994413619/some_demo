package com.ityc.se.juc.interview;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Author yuchao
 * @Description 曾经的面试题：（淘宝？）
 *              实现一个容器，提供两个方法，add，size
 *              写两个线程，线程1添加10个元素到容器中，线程2实现监控元素的个数，当个数到5个时，线程2给出提示并结束
 *
 *              分析下面这个程序，能完成这个功能吗？
 * @Date 2021/12/8 9:40
 **/
public class T01_Interview01_Volatile {

    //情况1：不使用volatile
    //List lists = new ArrayList();

    //情况2：使用volatile
    //volatile List lists = new ArrayList();

    //情况3：
    volatile List<Object> lists = Collections.synchronizedList(new LinkedList<>());

    public void add(Object o) {
        lists.add(o);
    }

    public int size() {
        return lists.size();
    }

    public static void main(String[] args) {
        T01_Interview01_Volatile c = new T01_Interview01_Volatile();

        new Thread(() -> {
            for(int i=0; i<10; i++) {
                c.add(new Object());
                System.out.println("add " + i);

                //加不加sleep,结果不太一样
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "t1").start();

        new Thread(() -> {
            while(true) {
                if(c.size() == 5) {//可能list中已经有5个了，但是size还是4，因为添加元素和size++是两个操作，不是原子的
                    break;
                }
            }
            System.out.println("t2 结束");
        }, "t2").start();
    }

}
