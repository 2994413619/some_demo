package com.ityc.se.juc.v1;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @Author yuchao
 * @Description queue���÷���
 * @Date 2021/12/21 10:18
 **/
public class T40_ConcurrentQueue {

    public static void main(String[] args) {
        Queue<String> strs = new ConcurrentLinkedQueue<>();

        for(int i=0; i<10; i++) {
            strs.offer("a" + i);  //add
        }

        System.out.println(strs);

        System.out.println(strs.size());

        System.out.println(strs.poll());//ȡ����remove
        System.out.println(strs.size());

        System.out.println(strs.peek());//ȡ����remove
        System.out.println(strs.size());

        //˫�˶���Deque
    }

}
