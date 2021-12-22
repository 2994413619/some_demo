package com.ityc.se.juc.v1;

import java.util.concurrent.*;

/**
 * @Author yuchao
 * @Description �̳߳ص���Callable,����ֵΪFuture,Callable�ķ��ؽ������Future��
 * @Date 2021/12/22 10:11
 **/
public class T47_Hello_Callable {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "hello Callable";
            }
        };

        ExecutorService service = Executors.newCachedThreadPool();
        Future future = service.submit(callable);//�첽
        System.out.println(future.get());//get()Ϊ�����ķ���
        service.shutdown();

    }

}
