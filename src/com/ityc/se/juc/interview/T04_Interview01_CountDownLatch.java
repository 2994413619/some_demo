package com.ityc.se.juc.interview;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @Author yuchao
 * @Description �����������⣺���Ա�����
 *              ʵ��һ���������ṩ����������add��size
 *              д�����̣߳��߳�1���10��Ԫ�ص������У��߳�2ʵ�ּ��Ԫ�صĸ�������������5��ʱ���߳�2������ʾ������
 *
 *              ��lists���volatile֮��t2�ܹ��ӵ�֪ͨ�����ǣ�t2�̵߳���ѭ�����˷�cpu�����������ѭ��������ô���أ�
 *
 *              ����ʹ��wait��notify������wait���ͷ�������notify�����ͷ���
 *              ��Ҫע����ǣ��������ַ���������Ҫ��֤t2��ִ�У�Ҳ����������t2�����ſ���
 *
 *              �Ķ�����ĳ��򣬲�����������
 *              ���Զ���������������size=5ʱt2�˳�������t1����ʱt2�Ž��յ�֪ͨ���˳�
 *              ��������Ϊʲô��
 *
 *              notify֮��t1�����ͷ�����t2�˳���Ҳ����notify��֪ͨt1����ִ��
 *              ����ͨ�Ź��̱ȽϷ���
 *
 *              ʹ��Latch�����ţ����wait notify������֪ͨ
 *              �ô���ͨ�ŷ�ʽ�򵥣�ͬʱҲ����ָ���ȴ�ʱ��
 *              ʹ��await��countdown�������wait��notify
 *              CountDownLatch���漰��������count��ֵΪ��ʱ��ǰ�̼߳�������
 *              �����漰ͬ����ֻ���漰�߳�ͨ�ŵ�ʱ����synchronized + wait/notify���Ե�̫����
 *              ��ʱӦ�ÿ���countdownlatch/cyclicbarrier/semaphore
 * @Date 2021/12/14 16:56
 **/
public class T04_Interview01_CountDownLatch {

    // ���volatile��ʹt2�ܹ��õ�֪ͨ
    volatile List list = new ArrayList();

    void add(Object o){
        list.add(o);
    }

    int size(){
        return list.size();
    }

    public static void main(String[] args) {
        T04_Interview01_CountDownLatch obj = new T04_Interview01_CountDownLatch();
        CountDownLatch latch = new CountDownLatch(1);

        new Thread(()->{
            System.out.println("t2����");

            if(obj.size() != 5) {
                try {
                    latch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("t2����");

        }, "t2").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }

        new Thread(()->{
            System.out.println("t1����");
            for(int i = 0; i < 10; i++) {
                obj.add(new Object());
                System.out.println("add " + i);
                if(obj.size() == 5) {
                    latch.countDown();
                }

                //ע��sleep�������һ���� add 4֮�󣬽��������ʹ������CountDownLatch
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
            System.out.println("t1����");
        }, "t1").start();

    }

}
