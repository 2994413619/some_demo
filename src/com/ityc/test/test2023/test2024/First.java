package com.ityc.test.test2023.test2024;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 测试两种生成随机数的方式
 * @author yuchao
 * @date 2024/2/6 9:33
 **/
public class First {

    public static void main(String[] args) {
        String transNo = "x-";
        Random random = new Random();
        for (int i = 0; i < 8; i++) {
            transNo += String.valueOf(random.nextInt(10));
        }
        transNo += "-";
        for (int i = 0; i < 8; i++) {
            transNo += String.valueOf(ThreadLocalRandom.current().nextInt(10));
        }
        System.out.println(transNo);

    }

}
