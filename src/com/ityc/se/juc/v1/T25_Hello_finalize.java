package com.ityc.se.juc.v1;

import java.io.IOException;

/**
 * @Author yuchao
 * @Description 垃圾回收的时候会调用finalize()
 *              这里重写是为了观察什么时候调用
 * @Date 2021/12/20 13:52
 **/
public class T25_Hello_finalize {

    @Override
    protected void finalize() throws Throwable {
        System.out.println("finalize");
    }

    public static void main(String[] args) throws IOException {

        //new 一个对象，这个对象就是强引用
        T25_Hello_finalize instance = new T25_Hello_finalize();
        instance = null;
        System.gc();
        System.in.read();//阻塞main 线程，因为gc()在别的线程执行，main结束一切都结束了
    }

}
