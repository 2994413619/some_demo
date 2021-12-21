package com.ityc.se.juc.interview;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author yuchao
 * @Description 两个线程交替打印A-Z、1-26
 * @Date 2021/12/21 15:57
 **/
public class T12_Interview03_printA1B2_CAS {

    enum ReadyToRun {T1, T2}

    static volatile ReadyToRun r = ReadyToRun.T1;

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
                while(r != ReadyToRun.T1) {}
                System.out.print(i + " ");
                r = ReadyToRun.T2;
            }

        });
        Thread t2 = new Thread(()->{
            for (char i : strList) {
                while(r != ReadyToRun.T2) {}
                System.out.print(i + " ");
                r = ReadyToRun.T1;
            }
        });

        t1.start();
        t2.start();
    }

}
