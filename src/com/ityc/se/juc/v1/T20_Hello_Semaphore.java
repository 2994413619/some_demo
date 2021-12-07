package com.ityc.se.juc.v1;

import java.util.concurrent.Semaphore;

/**
 * @Author yuchao
 * @Description 演示Semaphore，信号
 * @Date 2021/12/7 16:30
 **/
public class T20_Hello_Semaphore {
    public static void main(String[] args) {
        //Semaphore s = new Semaphore(2);
        Semaphore s = new Semaphore(2, true);
        //允许一个线程同时执行
        //Semaphore s = new Semaphore(1);

        new Thread(()->{
            try {
                s.acquire();//获得许可，信号减一

                System.out.println("T1 running...");
                Thread.sleep(200);
                System.out.println("T1 running...");

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                s.release();//释放许可
            }
        }).start();

        new Thread(()->{
            try {
                s.acquire();//没获取到，则阻塞在这

                System.out.println("T2 running...");
                Thread.sleep(200);
                System.out.println("T2 running...");

                s.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
