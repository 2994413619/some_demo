package com.mashibing.se.streamApi;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamApi2 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        //filter:筛选出偶数
        list.stream().filter((x) -> x % 2 == 0).forEach(System.out::println);

        System.out.println("-----------分割线-----------");

        //选出偶数并求和
        int sum = list.stream().filter(x -> x % 2 == 0).mapToInt(x -> x).sum();
        System.out.println(sum);

        System.out.println("-----------分割线-----------");

        //获得最大值
        Optional<Integer> max = list.stream().max((a, b) -> a - b);
        System.out.println(max.get());

        System.out.println("-----------分割线-----------");

        //获得最小值
        System.out.println(list.stream().min((a, b) -> a - b).get());

        System.out.println("-----------分割线-----------");

        //findAny
        System.out.println(list.stream().filter(x -> x % 2 == 0).findAny().get());

        System.out.println("-----------分割线-----------");

        //findFirst
        //如果filter后没有元素，findFirst会报错
        //
        System.out.println(list.stream().filter(x -> {
            System.out.println("执行" + x);
            return x % 2 == 0;
        }).findFirst().get());

        System.out.println("-----------分割线-----------");


        //排序
        List<String> strings = Arrays.asList("java", "C#", "javascript", "python", "scala");
        strings.stream().sorted().forEach(System.out::println);

        System.out.println("-----------分割线-----------");

        //倒序
        strings.stream().sorted((a, b) -> b.length() - a.length()).forEach(System.out::println);

        System.out.println("-----------分割线-----------");

        //将集合过滤后返回成集合
        List<Integer> collect = list.stream().filter(x -> x % 2 == 0).collect(Collectors.toList());
        collect.forEach(System.out::println);

        System.out.println("-----------分割线-----------");

        //去重操作,也可以用toSet()
        List<Integer> integers = Arrays.asList(1, 2, 12, 12, 1, 2, 4, 5, 4);
        List<Integer> collect1 = integers.stream().distinct().collect(Collectors.toList());
        collect1.forEach(System.out::println);

        System.out.println("-----------分割线-----------");

        //打印21到30
        Stream.iterate(1, x -> x + 1).limit(50).skip(20).limit(10).forEach(System.out::println);

        System.out.println("-----------分割线-----------");

        //求和
        String str2 = "11,22,33,44,55";
        System.out.println(Stream.of(str2.split(",")).mapToInt(x -> Integer.valueOf(x)).sum());
        System.out.println(Stream.of(str2.split(",")).mapToInt(Integer::valueOf).sum());

        System.out.println("-----------分割线-----------");

        //创建一组自定义对象
        String str3 = "java,C#,scala,python";
        Stream.of(str3.split(",")).map(Person::new).forEach(System.out::println);

        System.out.println("-----------分割线-----------");

        //将str2中每一个数值打印出来，并输出求和
        System.out.println(Stream.of(str2.split(",")).peek(System.out::println).mapToInt(Integer::valueOf).sum());

        //allMatch
        System.out.println(list.stream().allMatch(x -> x > 0));

    }
}

class Person{
    String name;

    public Person() {}

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}
