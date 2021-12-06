package com.ityc.se.juc.v2;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author yuchao
 * @Description interrupt能否打断等待lock锁的线程（不能）
 * @Date 2021/12/3 16:26
 **/
public class T08_Interrupt_and_lock {

    private static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
            lock.lock();
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
            System.out.println("t1 end!");
        });

        t1.start();
        TimeUnit.SECONDS.sleep(1);

        Thread t2 = new Thread(()->{
            lock.lock();
            try{

            } finally {
                lock.unlock();
            }
            System.out.println("t2 end!");
        });

        t2.start();
        TimeUnit.SECONDS.sleep(1);
        t2.interrupt();

    }

}
