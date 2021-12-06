package com.ityc.se.juc.v2;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author yuchao
 * @Description 线程状态
 * @Date 2021/12/3 14:40
 **/
public class T02_ThreadState {
    public static void main(String[] args) throws InterruptedException {
        /** ----------------------------------------   1 NEW、RUNNABLE、TERMINATED  -------------------------------------------------- */
        Thread t1 = new Thread(()->{
            System.out.println("2:" + Thread.currentThread().getState());//RUNNABLE
            for(int i = 0; i < 3; i++){
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.print(i +" ");
            }
            System.out.println();
        });
        System.out.println("1:" + t1.getState());//NEW
        t1.start();
        t1.join();//t1运行后，主线程在执行
        System.out.println("3:" + t1.getState());//TERMINATED

        /** ----------------------------------------   2 WAITING、TIMED_WAITING  -------------------------------------------------- */
        Thread t2 = new Thread(()->{
            LockSupport.park();
            System.out.println("t2 go on!");
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t2.start();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("4:" + t2.getState());//WAITING

        LockSupport.unpark(t2);
        TimeUnit.SECONDS.sleep(1);
        System.out.println("5:" + t2.getState());//TIMED_WAITING

        /** ----------------------------------------   3 BLOCKED  -------------------------------------------------- */
        Object o = new Object();
        Thread t3 = new Thread(()->{
            synchronized (o) {
                System.out.println("t3 得到了o的锁");
            }
        });

        new Thread(()->{
            synchronized (o) {
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        TimeUnit.SECONDS.sleep(1);

        t3.start();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("6:" + t3.getState());//BLOCKED

        /** ----------------------------------------   4 lock和synchronized状态区别  -------------------------------------------------- */
        final Lock lock = new ReentrantLock();
        Thread t4 = new Thread(()->{
            lock.lock();
            System.out.println("t4得到了锁 lock");
            lock.unlock();
        });

        new Thread(()->{
            lock.lock();
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.unlock();
        }).start();

        TimeUnit.SECONDS.sleep(1);
        t4.start();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("7:" + t4.getState());//只有synchronized没得到锁的状态是BLOCKED，其他的都是waiting，是忙等待

        /** ----------------------------------------   5 park的状态  -------------------------------------------------- */
        Thread t5 = new Thread(()->{
            LockSupport.park();
        });

        t5.start();

        TimeUnit.SECONDS.sleep(1);
        System.out.println("8:" + t5.getState());
        LockSupport.unpark(t5);

    }

}
