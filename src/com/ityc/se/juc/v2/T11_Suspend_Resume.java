package com.ityc.se.juc.v2;

import java.util.concurrent.TimeUnit;

/**
 * @Author yuchao
 * @Description suspend、resume容易产生死锁；suspend暂停后，如果没有resume,会一致不释放锁
 * @Date 2021/12/3 17:12
 **/
public class T11_Suspend_Resume {
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

        t.suspend();//暂停
        TimeUnit.SECONDS.sleep(3);
        t.resume();//继续

    }
}
