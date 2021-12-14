package com.ityc.se.juc.interview;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

public class T06_Interview01_LockSupport_without_sleep {

    // 添加volatile，使t2能够得到通知
    volatile List lists = new ArrayList();

    public void add(Object o) {
        lists.add(o);
    }

    public int size() {
        return lists.size();
    }

    static Thread t1 = null,t2 = null;

    public static void main(String[] args) {
        T05_Interview01_LockSupport obj = new T05_Interview01_LockSupport();



        t1 = new Thread(()->{
            System.out.println("t1 启动");
            for(int i = 0; i < 10; i++) {
                obj.add(new Object());
                System.out.println("add " + i);

                if(obj.size() == 5) {
                    LockSupport.unpark(t2);
                    LockSupport.park();
                }
            }
            System.out.println("t1 结束");
        }, "t1");

        t2 = new Thread(()->{
            System.out.println("t2 启动");

            //可以不判断，直接park()
            //if(obj.size() != 5) {
                LockSupport.park();
            //}
            System.out.println("t2 结束");
            LockSupport.unpark(t1);
        }, "t2");

        t2.start();

        t1.start();


    }

}
