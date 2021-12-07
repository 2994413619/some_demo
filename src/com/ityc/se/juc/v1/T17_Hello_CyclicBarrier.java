package com.ityc.se.juc.v1;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @Author yuchao
 * @Description 演示CyclicBarrier
 *              20个线程阻塞，然后一起执行。
 * @Date 2021/12/7 15:46
 **/
public class T17_Hello_CyclicBarrier {

    public static void main(String[] args) {

        //CyclicBarrier barrier = new CyclicBarrier(20);

        /*CyclicBarrier barrier = new CyclicBarrier(20, new Runnable() {
            @Override
            public void run() {
                System.out.println("满人，发车");
            }
        });*/

        CyclicBarrier barrier = new CyclicBarrier(20, () -> {
            System.out.println("满人，发车");
        });

        for(int i = 0; i < 100; i++) {
            new Thread(()->{
                try {
                    System.out.println("等待");
                    barrier.await();
                    System.out.println("执行");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }


    }

}
