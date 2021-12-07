package com.ityc.se.juc.v1;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author yuchao
 * @Description 演示ReentrantLock的用法
 *              使用syn锁定的话如果遇到异常，jvm会自动释放锁，但是lock必须手动释放锁，因此经常在finally中进行锁的释放
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
