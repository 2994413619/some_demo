package com.ityc.se.juc.v1;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @Author yuchao
 * @Description �н����
 * @Date 2021/12/21 10:49
 **/
public class T42_ArrayBlockingQueue {

    static BlockingQueue<String> strs = new ArrayBlockingQueue<>(10);

    static Random r = new Random();

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            strs.put("a" + i);
        }

        //strs.put("aaa"); //���˾ͻ�ȴ�����������
        //strs.add("aaa");//����add�����쳣
        //strs.offer("aaa");//���ˣ��᷵��false��ʾ���ʧ��
        strs.offer("aaa", 1, TimeUnit.SECONDS);//����һ���ʧ��

        System.out.println(strs);
    }

}
