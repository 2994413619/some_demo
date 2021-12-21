package com.ityc.se.juc.v1;

import java.util.PriorityQueue;

/**
 * @Author yuchao
 * @Description
 * @Date 2021/12/21 11:10
 **/
public class T44_PriorityQueque {

    public static void main(String[] args) {
        PriorityQueue<String> q = new PriorityQueue<>();

        q.add("c");
        q.add("e");
        q.add("a");
        q.add("d");
        q.add("z");

        for (int i = 0; i < 5; i++) {
            System.out.println(q.poll());
        }

    }

}
