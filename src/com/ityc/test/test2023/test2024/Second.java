package com.ityc.test.test2023.test2024;

/**
 *
 * @author yuchao
 * @date 2024/2/20 10:29
 **/
public class Second {

    public static void main(String[] args) {
        /*Integer i = null;
        System.out.println(String.valueOf(i));
        System.out.println(i == 1);*/
        /**
         * 测试Integer类型==和equals，==只会在-128——127之间有效
         */
        Integer a = 199, b = 199;
        System.out.println(a == b);
        System.out.println(a.equals(199));
        System.out.println(a.equals(null));
        Integer c = 1;
        System.out.println(c == 1);
    }

}
