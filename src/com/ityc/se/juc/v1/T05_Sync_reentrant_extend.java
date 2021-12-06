package com.ityc.se.juc.v1;

import java.util.concurrent.TimeUnit;

/**
 * @Author yuchao
 * @Description һ��ͬ���������Ե�������һ��ͬ��������һ���߳��Ѿ�ӵ��ĳ������������ٴ������ʱ����Ȼ��õ��ö������.
 *              Ҳ����˵synchronized��õ����ǿ������
 *              �����Ǽ̳����п��ܷ��������Σ�������ø����ͬ������
 * @Date 2021/12/6 11:03
 **/
public class T05_Sync_reentrant_extend {
    synchronized void m() {
        System.out.println("m start");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("m end");
    }

    public static void main(String[] args) {
        new TT().m();
    }

}

class TT extends T05_Sync_reentrant_extend {
    @Override
    synchronized void m() {
        System.out.println("child m start");
        super.m();
        System.out.println("child m end");
    }
}
