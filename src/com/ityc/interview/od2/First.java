package com.ityc.interview.od2;

import java.util.Scanner;

public class First {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        if(!isZM(str)) {
            str = "";
        }


        int i = 0;

        while(i < str.length() - 1) {
            if(str.charAt(i) == str.charAt(i + 1)) {
                str = str.replace(str.substring(i, i +2), "");

                if(i != 0) {
                    i -= 1;
                }

            } else {
                i++;
            }
        }

        System.out.println(str.length());

    }

    /**
     * 判断是否有非字母的字符
     **/
    public static boolean isZM(String str) {

        char temp;

        for(int i = 0; i < str.length(); i++) {
            temp = str.charAt(i);

            if(temp >= 97 && temp <= 122){
                continue;
            }

            if(temp >= 65 && temp <= 90){
                continue;
            }
            return false;
        }
        return true;
    }

}




