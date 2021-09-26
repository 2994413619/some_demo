package com.ityc.se.lambda;

import java.util.function.BiFunction;

/**
 * @Author yuchao
 * @Description 方法引用——对象方法引用
 * @Date 2021/9/17 22:00
 **/
public class Lambda2 {
    public static void main(String[] args) {
        BiFunction<Exec,String,Integer> b1 = Exec::getAge;
        System.out.println(b1.apply(new Exec(), "tom"));
    }
}
class Exec{
    public Integer getAge(String name) {
        return 10;
    }
}
