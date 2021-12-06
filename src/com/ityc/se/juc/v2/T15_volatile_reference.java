package com.ityc.se.juc.v2;

import java.util.concurrent.TimeUnit;

/**
 * @Author yuchao
 * @Description volatile修饰引用类型，里面的变量不可见
 * @Date 2021/12/4 22:33
 **/
public class T15_volatile_reference {


    //private static A a = new A();

    public static void main(String[] args) throws InterruptedException {

        A a = new A();

        new Thread(a::m, "t1").start();

        TimeUnit.SECONDS.sleep(1);

        a.running = false;

    }

}

class A{
    boolean running = true;
    void m(){
        System.out.println("m start!");
        while(running){}
        System.out.println("m end");
    }

}