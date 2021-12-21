package com.ityc.se.juc.interview;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TransferQueue;

/**
 * @Author yuchao
 * @Description 两个线程交替打印A-Z、1-26
 * @Date 2021/12/21 16:03
 **/
public class T17_Interview03_printA1B2_TransferQueue {

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

        TransferQueue<String> queue = new LinkedTransferQueue<>();

        Thread t1 = new Thread(()->{
            for(int i : intList) {
                try {
                    System.out.print(queue.take());
                    queue.transfer(i + " ");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        });
        Thread t2 = new Thread(()->{
            for (char i : strList) {
                try {
                    queue.transfer(i + " ");
                    System.out.print(queue.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();
    }

}
