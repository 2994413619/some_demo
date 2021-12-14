package com.ityc.se.juc.interview;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

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
 * @Date 2021/12/14 17:05
 **/
public class T05_Interview01_LockSupport {

    // ���volatile��ʹt2�ܹ��õ�֪ͨ
    volatile List lists = new ArrayList();

    public void add(Object o) {
        lists.add(o);
    }

    public int size() {
        return lists.size();
    }

    public static void main(String[] args) {
        T05_Interview01_LockSupport obj = new T05_Interview01_LockSupport();
        Thread t2 = new Thread(()->{
            System.out.println("t2 ����");

            if(obj.size() != 5) {
                LockSupport.park();
            }
            System.out.println("t2 ����");
        }, "t2");

        t2.start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }

        Thread t1 = new Thread(()->{
            System.out.println("t1 ����");
            for(int i = 0; i < 10; i++) {
                obj.add(new Object());
                System.out.println("add " + i);

                if(obj.size() == 5) {
                    LockSupport.unpark(t2);
                }

                //ע��sleep�������һ���� add 4֮��;�������������������park()-unpark() �磺T06_Interview1_LockSupport_without_sleep
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("t1 ����");
        }, "t1");
        t1.start();


    }

}
