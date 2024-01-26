package com.ityc.test.test2023;

import java.util.concurrent.atomic.AtomicLong;

public class Second {

    public static void main(String[] args) {
        AtomicLong j = new AtomicLong(99);
        Thread t1 = new Thread(() -> {
            while (true) {
                j.decrementAndGet();
                System.out.println(Thread.currentThread().getName() + ":" + j);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }, "t1");

        /*Thread t2 = new Thread(() -> {
            while (true) {
                j.decrementAndGet();
                System.out.println(Thread.currentThread().getName() + ":" + j);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }, "t2");*/

        Thread t3 = new Thread(() -> {
            while (true) {
                j.addAndGet(1);
                System.out.println(Thread.currentThread().getName() + ":" + j);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }, "t3");

        t1.start();
        t3.start();
    }

}
