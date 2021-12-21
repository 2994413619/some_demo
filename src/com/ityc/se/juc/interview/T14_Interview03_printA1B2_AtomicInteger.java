package com.ityc.se.juc.interview;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author yuchao
 * @Description 两个线程交替打印A-Z、1-26
 * @Date 2021/12/21 16:00
 **/
public class T14_Interview03_printA1B2_AtomicInteger {

    static AtomicInteger threadNo = new AtomicInteger(1);

    static List<Integer> intList;
    static List<Character> strList;

    static {
        intList = new ArrayList<>();
        strList = new ArrayList<>();
        for(int i = 0; i < 26; i++) {
            intList.add(i + 1);
            strList.add((char) ('A' + i));
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
            for(int i : intList) {
                while(threadNo.get() != 1) {}
                System.out.print(i + " ");
                threadNo.set(2);
            }

        });
        Thread t2 = new Thread(()->{
            for (char i : strList) {
                while(threadNo.get() != 2) {}
                System.out.print(i + " ");
                threadNo.set(1);
            }
        });

        t1.start();
        t2.start();
    }

}
