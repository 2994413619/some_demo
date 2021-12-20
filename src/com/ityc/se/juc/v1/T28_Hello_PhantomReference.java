package com.ityc.se.juc.v1;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author yuchao
 * @Description ������
 *              һ�������Ƿ��������õĴ��ڣ���ȫ�����������ʱ�乹��Ӱ�죬
 *              Ҳ�޷�ͨ������������ȡһ�������ʵ����
 *              Ϊһ���������������ù�����ΨһĿ�ľ���������������ռ�������ʱ�յ�һ��ϵͳ֪ͨ��
 *              �����ú������öԹ�������Ļ��ն��������Ӱ�죬���ֻ�������û��������ù����Ŷ���
 *              ��ô�������ͻᱻ���ա����ǵĲ�֮ͬ�����������õ�get�����������õ�get����ʼ�շ���null,
 *              �����ÿ���ʹ��ReferenceQueue,�����ñ������ReferenceQueueʹ�á�
 *              jdk��ֱ���ڴ�Ļ��վ��õ������ã�����jvm�Զ��ڴ����ķ�Χ�Ƕ��ڴ棬
 *              ��ֱ���ڴ����ڶ��ڴ�֮�⣨��ʵ���ڴ�ӳ���ļ�������ȥ��������ڴ�ռ����ظ����
 *              ����ֱ���ڴ�ķ���ͻ��ն�����Unsafe��ȥ������java������һ��ֱ���ڴ�֮��
 *              ���ڶ��ڴ����һ�����󱣴���������ڴ�����ã�
 *              ������������ռ�������һ��������󱻻��գ�
 *              ��Ӧ���û��̻߳��յ�֪ͨ����ֱ���ڴ������������
 *              ��ʵ�ϣ���������һ������Ҫ����;���������������ڴ���ͷţ�
 *              DirectByteBuffer����ͨ����������ʵ�ֶ����ڴ���ͷŵġ�
 *
 *              ���иó���������ò��������ö��ڴ�������С����20M��-Xms20M -Xmx20M
 * @Date 2021/12/20 14:46
 **/
public class T28_Hello_PhantomReference {

    private static final List<Object> LIST = new LinkedList<>();
    private static final ReferenceQueue<M> QUEUE = new ReferenceQueue<>();

    public static void main(String[] args) {

        PhantomReference<M> phantomReference = new PhantomReference<>(new M(), QUEUE);

        //���̲߳����������1M
        new Thread(() -> {
            while (true) {
                LIST.add(new byte[1024 * 1024]);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    Thread.currentThread().interrupt();
                }
                //��������get������
                System.out.println(phantomReference.get());
            }
        }).start();

        //��������������Ƿ񱻻�����
        new Thread(() -> {
            while (true) {
                Reference<? extends M> poll = QUEUE.poll();
                if (poll != null) {
                    System.out.println("--- �����ö���jvm������ ---- " + poll);
                }
            }
        }).start();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}

class M {
    @Override
    protected void finalize() throws Throwable {
        System.out.println("finalize");
    }
}