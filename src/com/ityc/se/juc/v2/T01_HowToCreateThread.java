package com.ityc.se.juc.v2;

import java.util.concurrent.*;

/**
 * @Author yuchao
 * @Description 通过Callable启动线程；通过线程池启动线程
 * @Date 2021/12/1 21:48
 * @Param
 * @return
 **/
public class T01_HowToCreateThread {

    public static void main(String[] args) throws Exception{
        FutureTask<String> task = new FutureTask<String>(new MyCall());
        Thread t = new Thread(task);
        t.start();
        System.out.println(task.get());

        ExecutorService service = Executors.newCachedThreadPool();
        service.execute(()->{
            System.out.println("hello ThreadPool");
        });
        Future<String> f = service.submit(new MyCall());
        String s = f.get();
        System.out.println(s);
        service.shutdown();

    }
}

class MyCall implements Callable<String> {
    @Override
    public String call(){
        System.out.println("Hello MyCall");
        return "success";
    }
}