package com.ityc.se.juc.v1;

/**
 * @Author yuchao
 * @Description ���̲߳���ͬһ��������������������
 * @Date 2021/12/5 16:03
 **/
public class T01_First_demo  implements Runnable {

    private /*volatile*/ int count = 100;

    public /*synchronized*/ void run() {
        count--;
        System.out.println(Thread.currentThread().getName() + " count = " + count);
    }

    public static void main(String[] args) {
        T01_First_demo t = new T01_First_demo();
        for(int i=0; i<100; i++) {
            new Thread(t, "THREAD--" + i).start();
        }
    }

}
