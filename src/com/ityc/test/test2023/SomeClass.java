package com.ityc.test.test2023;

// 实现一个类似String的indexOf(String str)的方法，用最简单实现即可
// 查找字符串str在目标字符串source中第一次出现的位置。
// 不可以调用任何第三方库，也不可以用String.equals， String.substring 方法
// 注意边界条件
public class SomeClass {
    public static int indexOf(String source, String str) {

        out : for(int i = 0; i <= source.length() - str.length(); i++) {
            for(int j = 0; j < str.length(); j++) {
                if(source.charAt(i + j) != str.charAt(j)) {
                    continue out;
                }
            }
            return i;
        }

        return -1;
    }
    public static void main(String[] args) {
        System.out.println(indexOf("abcabdef", "bde"));
    }
}
