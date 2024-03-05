package com.ityc.test.test2023.test2024;

import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.Date;

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
        /**
         * 测试获得当前时间yyyy-MM-dd HH:mm:ss
         */
        Date data = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(format.format(data));

    }

}
