package com.ityc.se.juc.v1;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author yuchao
 * @Description ��ʾReentrantLock���÷�
 *              ʹ��syn�����Ļ���������쳣��jvm���Զ��ͷ���������lock�����ֶ��ͷ�������˾�����finally�н��������ͷ�
 * @Date 2021/12/7 14:44
 **/
public class T12_Hello_ReentrantLock {

    ReentrantLock lock = new ReentrantLock();

    void m1(){
        try {
            lock.lock();

            for(int i = 0; i < 10; i++) {
                TimeUnit.SECONDS.sleep(1);
                System.out.println(i);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    void m2(){
        try {
            lock.lock();
            System.out.println("m2....");
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        T12_Hello_ReentrantLock instance = new T12_Hello_ReentrantLock();
        new Thread(instance::m1).start();
        TimeUnit.SECONDS.sleep(1);
        new Thread(instance::m2).start();
    }

}
