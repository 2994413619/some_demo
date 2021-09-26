package com.ityc.se.streamApi;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @Author yuchao
 * @Description 生成stream的5中方式
 * @Date 2021/9/18 23:01
 **/
public class StreamApi1 {
    public static void main(String[] args) {
        gen1();
        System.out.println("---------------------");
        gen2();
        System.out.println("---------------------");
        gen4();
        System.out.println("---------------------");
        gen5();
        System.out.println("---------------------");
        gen6();
    }

    //1、数组生成stream
    static void gen1(){
        String[] strs = {"a","b","c","d"};
        Stream<String> strsStream = Stream.of(strs);
        strsStream.forEach(System.out::println);
    }

    //2、集合生成stream
    static void gen2(){
        List<String> strs = Arrays.asList("1", "2", "3", "4", "5");
        Stream<String> strStream = strs.stream();
        strStream.forEach(System.out::println);
    }

    //3、generate——无限输出1
    static void gen3(){
        Stream<Integer> generate = Stream.generate(() -> 1);
        generate.forEach(System.out::print);
        System.out.println();
    }

    //limit——输出9个1
    static void gen4(){
        Stream<Integer> generate = Stream.generate(() -> 1);
        generate.limit(9).forEach(System.out::print);
        System.out.println();
    }

    //4、iterate——生成1到10的流
    static void gen5(){
        Stream<Integer> iterate = Stream.iterate(1, x -> x + 1);
        iterate.limit(10).forEach(System.out::println);
    }

    //5、其他API生成stream
    static void gen6(){
        String str = "abcdef";
        IntStream chars = str.chars();
        chars.forEach(System.out::println);
    }

}
