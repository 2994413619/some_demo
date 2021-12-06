package com.ityc.se.juc.v2;

import java.util.concurrent.CountDownLatch;

/**
 * @Author yuchao
 * @Description ����ִ��֤��
 * @Date 2021/12/5 13:30
 **/
public class T17_Disorder {

    private static int a = 0, b = 0;
    private static int x = 0, y = 0;

    public static void main(String[] args) throws InterruptedException {
        for(long i = 0; i < Long.MAX_VALUE; i++) {
            a = 0;
            b = 0;
            x = 0;
            y = 0;

            CountDownLatch latch = new CountDownLatch(2);

            Thread t1 = new Thread(() -> {
                a = 1;
                x = b;
                latch.countDown();
            });

            Thread t2 = new Thread(()->{
                b = 1;
                y = a;
                latch.countDown();
            });

            t1.start();
            t2.start();
            latch.await();

            if(x == 0 && y ==0) {
                System.out.println("��" + i + "�Σ�x=" + x + ", y=" + y);
                break;
            }

        }
    }

}
