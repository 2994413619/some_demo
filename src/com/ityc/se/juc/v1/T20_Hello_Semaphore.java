package com.ityc.se.juc.v1;

import java.util.concurrent.Semaphore;

/**
 * @Author yuchao
 * @Description ��ʾSemaphore���ź�
 * @Date 2021/12/7 16:30
 **/
public class T20_Hello_Semaphore {
    public static void main(String[] args) {
        //Semaphore s = new Semaphore(2);
        Semaphore s = new Semaphore(2, true);
        //����һ���߳�ͬʱִ��
        //Semaphore s = new Semaphore(1);

        new Thread(()->{
            try {
                s.acquire();//�����ɣ��źż�һ

                System.out.println("T1 running...");
                Thread.sleep(200);
                System.out.println("T1 running...");

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                s.release();//�ͷ����
            }
        }).start();

        new Thread(()->{
            try {
                s.acquire();//û��ȡ��������������

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
