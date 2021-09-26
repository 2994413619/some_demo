package com.mashibing.se.lambda;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @Author yuchao
 * @Description 方法引用——构造方法引用
 * @Date 2021/9/17 22:02
 **/
public class Lambda3 {
    public static void main(String[] args) {
        //无参构造方法
        Supplier<List> s1 = ArrayList::new;
        Supplier<Set> s2 = HashSet::new;
        Supplier<Count> s3 = Count::new;

        //有参构造方法
        Consumer<String> c1 = Count::new;
        c1.accept("tom");

        Function<String, Count> f1 = Count::new;
        Count tom = f1.apply("tom");

    }

}

class Count{
    public Count(){}

    public Count(String str){
        System.out.println("有参构造方法:hello " + str);
    }

}