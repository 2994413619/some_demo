package com.ityc.test.test2023.test2024;

/**
 * 测试Integer在方法调用后会不会返回计算后的值
 * @author yuchao
 * @date 2024/4/9 20:22
 **/
public class Fourth {

    public static void main(String[] args) {
        Integer count = 0;
        add(count);
        System.out.println(count);
    }


    public static void add(Integer count) {
        count += 1;
    }

}
