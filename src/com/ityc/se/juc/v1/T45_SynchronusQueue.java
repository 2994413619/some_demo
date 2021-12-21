package com.ityc.se.juc.v1;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * @Author yuchao
 * @Description �̼߳䴫������������Ϊ0��һ
 *              ���߳�put()����һ���߳�take()��������Ϊ����������Ҳ����˵���û���߳�take()����ôput()��һ����������֮��Ȼ��
 *              �Լ�ʵ���̳߳س��á�
 * @Date 2021/12/21 11:07
 **/
public class T45_SynchronusQueue { //����Ϊ0

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> strs = new SynchronousQueue<>();

        new Thread(()->{
            try {
                System.out.println(strs.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        strs.put("aaa"); //�����ȴ�����������
        //strs.put("bbb");
        //strs.add("aaa");
        System.out.println(strs.size());
    }

}
