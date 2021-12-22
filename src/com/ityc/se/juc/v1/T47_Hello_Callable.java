package com.ityc.se.juc.v1;

import java.util.concurrent.*;

/**
 * @Author yuchao
 * @Description 线程池调用Callable,返回值为Future,Callable的返回结果存在Future中
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
        Future future = service.submit(callable);//异步
        System.out.println(future.get());//get()为阻塞的方法
        service.shutdown();

    }

}
