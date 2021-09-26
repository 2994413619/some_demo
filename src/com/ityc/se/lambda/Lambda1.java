package com.ityc.se.lambda;

import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * @Author yuchao
 * @Description lambda表达式和方法引用
 * @Date 2021/9/17 22:01
 **/
public class Lambda1 {

    static String getName(){
        return "LuFei";
    }

    static void ssetName(String name){
        System.out.println(name);
    }

    public static void main(String[] args) {
        //方式一：lambda表达式
        Supplier<String> s1 = ()-> Lambda1.getName();
        System.out.println(s1.get());

        //方式二:方法引用
        Supplier<String> s2 = Lambda1::getName;
        System.out.println(s2.get());

        //方法引用：c1
        Consumer<String> c1 = Lambda1::ssetName;
        c1.accept("tom");

        //lambda表达式和方法引用c1对比
        Consumer<String> c2 = name -> Lambda1.ssetName(name);
        c2.accept("tom2");

    }

}

