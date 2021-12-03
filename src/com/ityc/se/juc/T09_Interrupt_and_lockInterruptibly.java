package com.ityc.se.juc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author yuchao
 * @Description 使用lock.lockInterruptibly()使线程可以被打断
 * @Date 2021/12/3 16:35
 **/
public class T09_Interrupt_and_lockInterruptibly {

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
            System.out.println("t2 start!");
            try{
                lock.lockInterruptibly();
            } catch (InterruptedException e) {
                e.printStackTrace();
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
