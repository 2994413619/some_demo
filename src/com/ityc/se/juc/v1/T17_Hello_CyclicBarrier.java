package com.ityc.se.juc.v1;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @Author yuchao
 * @Description ��ʾCyclicBarrier
 *              20���߳�������Ȼ��һ��ִ�С�
 * @Date 2021/12/7 15:46
 **/
public class T17_Hello_CyclicBarrier {

    public static void main(String[] args) {

        //CyclicBarrier barrier = new CyclicBarrier(20);

        /*CyclicBarrier barrier = new CyclicBarrier(20, new Runnable() {
            @Override
            public void run() {
                System.out.println("���ˣ�����");
            }
        });*/

        CyclicBarrier barrier = new CyclicBarrier(20, () -> {
            System.out.println("���ˣ�����");
        });

        for(int i = 0; i < 100; i++) {
            new Thread(()->{
                try {
                    System.out.println("�ȴ�");
                    barrier.await();
                    System.out.println("ִ��");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }


    }

}
