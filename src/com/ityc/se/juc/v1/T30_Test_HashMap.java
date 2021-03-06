package com.ityc.se.juc.v1;

import java.util.HashMap;
import java.util.UUID;

/**
 * @Author yuchao
 * @Description 测试Hashtable读写效率
 *              100个线程写入100w个entry到Hashtable中
 *              100个线程分别读1000w次第10个元素，看执行时间
 * @Date 2021/12/20 16:09
 **/
public class T30_Test_HashMap {

    static HashMap<UUID, UUID> m = new HashMap<>();

    static int count = 1000000;
    static UUID[] keys = new UUID[count];
    static UUID[] values = new UUID[count];
    static final int THREAD_COUNT = 100;

    static {
        for (int i = 0; i < count; i++) {
            keys[i] = UUID.randomUUID();
            values[i] = UUID.randomUUID();
        }
    }

    static class MyThread extends Thread {
        int start;
        int gap = count/THREAD_COUNT;

        public MyThread(int start) {
            this.start = start;
        }

        @Override
        public void run() {
            for(int i=start; i<start+gap; i++) {
                m.put(keys[i], values[i]);
            }
        }
    }

    public static void main(String[] args) {

        long start = System.currentTimeMillis();

        Thread[] threads = new Thread[THREAD_COUNT];

        for(int i=0; i<threads.length; i++) {
            threads[i] =
                    new MyThread(i * (count/THREAD_COUNT));
        }

        for(Thread t : threads) {
            t.start();
        }

        for(Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        long end = System.currentTimeMillis();
        System.out.println(end - start);

        System.out.println(m.size());
    }

}
