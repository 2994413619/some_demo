package com.ityc.jvm.classloader;

/**
 * @Author yuchao
 * @Description 查看类加载器各自加载的路径
 * @Date 2021/9/24 15:44
 **/
public class Second {
    public static void main(String[] args) {
        String pathBoot = System.getProperty("sun.boot.class.path");
        System.out.println(pathBoot.replaceAll(";",System.lineSeparator()));

        System.out.println("-------------------------------------------");
        String extBoot = System.getProperty("java.ext.dirs");
        System.out.println(extBoot.replaceAll(";",System.lineSeparator()));

        System.out.println("-------------------------------------------");
        String appBoot = System.getProperty("java.class.path");
        System.out.println(appBoot.replaceAll(";",System.lineSeparator()));
    }
}
