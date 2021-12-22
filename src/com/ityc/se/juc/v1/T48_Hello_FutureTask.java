package com.ityc.se.juc.v1;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * @Author yuchao
 * @Description FutureTask既实现Runnable接口又实现了Future接口，成员变量也有Callable，他可以当一个线程来运行，运行结果也放在FutureTask对象中
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
