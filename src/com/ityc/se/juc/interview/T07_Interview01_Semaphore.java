package com.ityc.se.juc.interview;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author yuchao
 * @Description ֱ����join������Semaphore������ʵ��
 *              Semaphore����ֱ��ʵ��
 * @Date 2021/12/14 17:41
 **/
public class T07_Interview01_Semaphore {

    // ���volatile��ʹt2�ܹ��õ�֪ͨ
    volatile List lists = new ArrayList();

    public void add(Object o) {
        lists.add(o);
    }

    public int size() {
        return lists.size();
    }

    static Thread t1 = null, t2 = null;

    public static void main(String[] args) {
        T07_Interview01_Semaphore c = new T07_Interview01_Semaphore();
        //Semaphore s = new Semaphore(1);

        t1 = new Thread(() -> {
            //try {
                //s.acquire();
                for (int i = 0; i < 5; i++) {
                    c.add(new Object());
                    System.out.println("add " + i);


                }
                //s.release();
            //} catch (InterruptedException e) {
               // e.printStackTrace();
            //}

            try {
                t2.start();
                t2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //try {
                //s.acquire();
                for (int i = 5; i < 10; i++) {
                    System.out.println(i);
                }
               // s.release();
            //} catch (InterruptedException e) {
                //e.printStackTrace();
            //}

        }, "t1");

        t2 = new Thread(() -> {
            //try {
                //s.acquire();
                System.out.println("t2 ����");
                //s.release();
            //} catch (InterruptedException e) {
                //e.printStackTrace();
            //}
        }, "t2");

        //t2.start();
        t1.start();
    }

}
