package com.ityc.se.juc.interview;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.LockSupport;

/**
 * @Author yuchao
 * @Description 两个线程交替打印A-Z、1-26
 *              使用LockSupport实现
 * @Date 2021/12/21 15:40
 **/
public class T11_Interview03_printA1B2_LockSupport {

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

    static Thread t1, t2;

    public static void main(String[] args) {

        t1 = new Thread(()->{
            for(int i : intList) {
                LockSupport.park();
                System.out.print(i + " ");
                LockSupport.unpark(t2);
            }

        });
        t2 = new Thread(()->{
            for (char i : strList) {
                System.out.print(i + " ");
                LockSupport.unpark(t1);
                LockSupport.park();
            }
        });

        t1.start();
        t2.start();
    }

}
