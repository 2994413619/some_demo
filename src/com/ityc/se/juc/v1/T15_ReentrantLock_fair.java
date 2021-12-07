package com.ityc.se.juc.v1;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author yuchao
 * @Description ReentrantLockʹ�ù�ƽ��
 * @Date 2021/12/7 15:12
 **/
public class T15_ReentrantLock_fair extends Thread {

    ReentrantLock lock = new ReentrantLock(true);

    public void run() {
        for(int i = 0; i < 100; i++) {
            try {
                lock.lock();
                System.out.println(Thread.currentThread().getName() + "�����");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        T15_ReentrantLock_fair instance = new T15_ReentrantLock_fair();

        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
        t1.start();
        t2.start();

    }

}
