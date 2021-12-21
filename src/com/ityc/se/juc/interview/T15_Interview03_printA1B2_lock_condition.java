package com.ityc.se.juc.interview;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author yuchao
 * @Description 两个线程交替打印A-Z、1-26
 * @Date 2021/12/21 16:01
 **/
public class T15_Interview03_printA1B2_lock_condition {

    static ReentrantLock lock = new ReentrantLock();
    static Condition condition = lock.newCondition();

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

            try {
                lock.lock();

                for(int i : intList) {
                    System.out.print(i + " ");
                    condition.signal();
                    condition.await();
                }
                condition.signal();

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        });
        Thread t2 = new Thread(()->{

            try {
                lock.lock();

                for (char i : strList) {
                    System.out.print(i + " ");
                    condition.signal();
                    condition.await();
                }
                condition.signal();

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        });

        t1.start();
        t2.start();
    }

}
