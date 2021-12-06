package com.ityc.se.juc.v1;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author yuchao
 * @Description 使用AtomicInteger保证原子性
 * @Date 2021/12/6 15:53
 **/
public class T09_AtomicInteger {

    AtomicInteger count = new AtomicInteger(0);

    void m(){
        for(int i = 0; i < 10000; i++) {
            count.incrementAndGet();
        }
    }

    public static void main(String[] args) {
        T09_AtomicInteger instance = new T09_AtomicInteger();

        ArrayList<Thread> list = new ArrayList<>();

        for(int i = 0; i < 10; i++) {
            list.add(new Thread(instance::m, "thread-" + i));
        }

        list.forEach((o)->{o.start();});

        list.forEach((o)->{
            try {
                o.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.println(instance.count);

    }

}
