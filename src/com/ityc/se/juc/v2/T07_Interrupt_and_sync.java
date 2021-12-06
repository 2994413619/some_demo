package com.ityc.se.juc.v2;

import java.util.concurrent.TimeUnit;

/**
 * @Author yuchao
 * @Description interrupt会不会打断正在争抢锁、竞争锁的线程（结果：不能）
 * @Date 2021/12/3 16:19
 * @Param
 * @return
 **/
public class T07_Interrupt_and_sync {

    public static Object o = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
            synchronized (o) {
                try {
                    TimeUnit.SECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();

        TimeUnit.SECONDS.sleep(1);

        Thread t2 = new Thread(()->{
            synchronized (o) {

            }
            System.out.println("t2 end!");
        });

        t2.start();
        TimeUnit.SECONDS.sleep(1);
        t2.interrupt();
    }
}
