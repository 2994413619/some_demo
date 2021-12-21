package com.ityc.se.juc.v1;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.CountDownLatch;

/**
 * @Author yuchao
 * @Description �Աȸ���Map��д��Ч��
 *              ����100���̣߳�ÿ���߳�put 10000��entry������������map����ʱ�䣬���mapԪ�ظ���
 * @Date 2021/12/21 9:54
 **/
public class T37_ConcurrentMap {

    public static void main(String[] args) {
        Map<String, String> map = new ConcurrentHashMap<>();
        //Map<String, String> map = new ConcurrentSkipListMap<>(); //�߲�����������

        //Map<String, String> map = new Hashtable<>();//901
        //Map<String, String> map = new HashMap<>(); //Collections.synchronizedXXX
        //TreeMap
        Random r = new Random();
        Thread[] ths = new Thread[100];
        CountDownLatch latch = new CountDownLatch(ths.length);
        long start = System.currentTimeMillis();
        for(int i=0; i<ths.length; i++) {
            ths[i] = new Thread(()->{
                for(int j=0; j<10000; j++) map.put("a" + r.nextInt(100000), "a" + r.nextInt(100000));
                latch.countDown();
            });
        }

        Arrays.asList(ths).forEach(t->t.start());
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();
        System.out.println(end - start);
        System.out.println(map.size());

    }

}
