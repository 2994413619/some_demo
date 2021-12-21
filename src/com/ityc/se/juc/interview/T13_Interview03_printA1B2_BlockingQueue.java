package com.ityc.se.juc.interview;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @Author yuchao
 * @Description 两个线程交替打印A-Z、1-26
 * @Date 2021/12/21 15:59
 **/
public class T13_Interview03_printA1B2_BlockingQueue {


    static BlockingQueue queueT1 = new ArrayBlockingQueue<String>(1);
    static BlockingQueue queueT2 = new ArrayBlockingQueue<String>(1);

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
                System.out.print(i + " ");
                try {
                    queueT2.put("run");
                    queueT1.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        });
        Thread t2 = new Thread(()->{
            for (char i : strList) {
                try {
                    queueT2.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.print(i + " ");
                try {
                    queueT1.put("run");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();
    }

}
