package com.ityc.se.juc.v2;

import java.util.concurrent.TimeUnit;

/**
 * @Author yuchao
 * @Description 使用stop结束线程(不建议使用，太粗暴，不管线程处在什么状态，直接释放所有锁，可能导致数据不一致)
 * @Date 2021/12/3 17:07
 **/
public class T10_Stop {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(()->{
            while(true) {//模拟线程一直在工作，如上传文件，提供服务
                System.out.println("go on");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();
        TimeUnit.SECONDS.sleep(5);
        t.stop();
    }
}
