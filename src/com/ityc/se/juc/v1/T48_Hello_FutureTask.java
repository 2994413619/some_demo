package com.ityc.se.juc.v1;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * @Author yuchao
 * @Description FutureTask��ʵ��Runnable�ӿ���ʵ����Future�ӿڣ���Ա����Ҳ��Callable�������Ե�һ���߳������У����н��Ҳ����FutureTask������
 * @Date 2021/12/22 10:18
 **/
public class T48_Hello_FutureTask {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> task = new FutureTask<Integer>(()->{
            TimeUnit.SECONDS.sleep(1);
            return 1000;
        });

        new Thread(task).start();

        System.out.println(task.get());
    }

}
