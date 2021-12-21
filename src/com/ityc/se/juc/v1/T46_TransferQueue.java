package com.ityc.se.juc.v1;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TimeUnit;

/**
 * @Author yuchao
 * @Description �̼߳䴫��������
 * @Date 2021/12/21 11:08
 **/
public class T46_TransferQueue {

    public static void main(String[] args) throws InterruptedException {
        LinkedTransferQueue<String> strs = new LinkedTransferQueue<>();

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
                System.out.println(strs.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        strs.transfer("aaa");//������к��������ȵ���ȡ����ż�������ִ��

        System.out.println("main over");

        //strs.put("aaa");


		/*new Thread(() -> {
			try {
				System.out.println(strs.take());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();*/


    }

}
