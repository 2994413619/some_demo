package com.ityc.interview.zhongruan;

import java.util.Scanner;

public class First {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        StringBuilder builderStr = new StringBuilder();
        StringBuilder builderNumber = new StringBuilder();
        for(int i = 0; i < str.length(); i++) {
            if(isZM(str.charAt(i))) {//是字母
                builderStr.append(str.charAt(i));
            } else {
                builderNumber.append(str.charAt(i));
            }
        }
        System.out.println(builderStr.toString() + builderNumber.toString());

    }

    /**
     * 判断是否为字符
     * @param c
     * @return
     */
    public static boolean isZM(Character c) {
        if(c >= 'a' && c <= 'z') {
            return true;
        }
        if(c >= 'A' && c <= 'Z') {
            return true;
        }
        return false;
    }

}
