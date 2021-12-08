package com.ityc.se.juc.v1;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * @Author yuchao
 * @Description ��ʾLockSupport
 * @Date 2021/12/8 9:29
 **/
public class T22_Hello_LockSupport {
    public static void main(String[] args) {
        Thread t = new Thread(()->{
            for (int i = 0; i < 10; i++) {
                System.out.println(i);
                if(i == 5) {
                    LockSupport.park();//park:ͣ��
                }
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t.start();

        //�߳�t�Ѿ�ִ�У���ûpark(),���ǿ����ȵ���unpark()��unpark������parkִ��
        //LockSupport.unpark(t);

        try {
            TimeUnit.SECONDS.sleep(8);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("after 8 senconds!");

        LockSupport.unpark(t);

    }
}
