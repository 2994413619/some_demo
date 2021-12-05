package com.ityc.se.juc;

/**
 * @Author yuchao
 * @Description 乱序执行导致程序结果和预料的不一样
 * @Date 2021/12/5 14:45
 **/
public class T18_NoVisibility {

    private static volatile boolean ready = false;
    private static int number = 0;

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            while (!ready) {
                Thread.yield();
            }
            System.out.println(number);
        });

        t1.start();

        //这两句没有依赖关系，可能乱序执行，导致number输出0
        number = 42;
        ready = true;

    }

}
