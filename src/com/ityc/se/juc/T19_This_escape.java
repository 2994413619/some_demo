package com.ityc.se.juc;

import java.io.IOException;

/**
 * @Author yuchao
 * @Description this对象溢出
 * @Date 2021/12/5 15:21
 **/
public class T19_This_escape {

    private int num = 8;

    public T19_This_escape(){
        new Thread(()->{
            System.out.println(this.num);//有可能输出0
        }).start();
    }

    public static void main(String[] args) throws IOException {
        new T19_This_escape();
        System.in.read();//保证主线程结束前，上面那个线程执行玩
    }

}
