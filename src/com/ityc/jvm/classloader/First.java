package com.ityc.jvm.classloader;

/**
 * @Author yuchao
 * @Description 查看各个类使用的类加载器
 * @Date 2021/9/24 14:48
 **/
public class First {
    public static void main(String[] args) {
        System.out.println("输出null表示bootstrap加载器，因为是c++实现的");
        System.out.println(String.class.getClassLoader());
        System.out.println(sun.net.spi.nameservice.dns.DNSNameService.class.getClassLoader());
        System.out.println(First.class.getClassLoader());
        //父加载器不是说的类继承关系，是加载的逻辑关系
        System.out.println("app加载器的父加载器：" + First.class.getClassLoader().getParent());
        System.out.print("extClassLoader的加载器是：");
        System.out.println(sun.net.spi.nameservice.dns.DNSNameService.class.getClassLoader().getClass().getClassLoader());
    }

}
