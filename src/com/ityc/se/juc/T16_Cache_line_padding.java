package com.ityc.se.juc;

import sun.misc.Contended;

import java.util.concurrent.CountDownLatch;

/**
 * @Author yuchao
 * @Description 缓存行——缓存一致性协议
 *          JDK 1.7就是使用了这种填充的写法（LinkedBlockingQueue）
 *          disruptor开源框架也用来这种写法（单机最强的MQ）RingBuffer类中
 * @Date 2021/12/4 22:52
 **/
public class T16_Cache_line_padding {

    public static long COUNT = 10_0000_0000L;

    private static class T{
        //private long p1,p2,p3,p4,p5,p6,p7;
        @Contended //只有jdk1.8起作用  使用时加上参数：-XX:-RestrictContended
        public long x = 0L;
        //private long p8,p9,p10,p11,p12,p13,p14,p15;
    }

    public static T[] arr = new T[2];

    static {
        arr[0] = new T();
        arr[1] = new T();
    }

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(2);
        Thread t1 = new Thread(() -> {
            for (long i = 0; i < COUNT; i++) {
                arr[0].x = i;
            }
            latch.countDown();
        });

        Thread t2 = new Thread(() -> {
            for (long i = 0; i < COUNT; i++) {
                arr[1].x = i;
            }
            latch.countDown();
        });

        final long startTime = System.nanoTime();
        t1.start();
        t2.start();
        latch.await();
        System.out.println((System.nanoTime() - startTime) / 100_0000);

    }

}


