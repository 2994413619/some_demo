package com.ityc.se.juc.v1;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author yuchao
 * @Description ��ʾReentrantLock��tryLock()����
 *              m1�������ִ��10�룬m2 tryLock 5�룬û����������m2������
 * @Date 2021/12/7 14:54
 **/
public class T13_ReentrantLock_tryLock {

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
        boolean flag = false;
        try {
            flag = lock.tryLock(5, TimeUnit.SECONDS);
            System.out.println("m2 try Lock:" + flag);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if(flag){
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        T13_ReentrantLock_tryLock instance = new T13_ReentrantLock_tryLock();
        new Thread(instance::m1).start();
        TimeUnit.SECONDS.sleep(1);
        new Thread(instance::m2).start();
    }

}
