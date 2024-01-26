package com.ityc.interview.rt_ry;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Third {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String str = sc.nextLine();
            System.out.println(judge(str));
        }
    }

    public static String judge(String str) {
        // 长度大于8
        if(str.length() <= 8) {
            return "NG";
        }

        // 三种以上字符
        int[] count = new int[4];// 0-小写 1-大写 2-数字 3-其他
        char temp;
        for(int i = 0; i < str.length(); i++) {
            temp = str.charAt(i);
            if(temp >= 'a' && temp <= 'z') {
                count[0] = 1;
            } else if (temp >= 'A' && temp <= 'Z') {
                count[1] = 1;
            } else if (temp >= '0' && temp <= '9') {
                count[2] = 1;
            } else if(temp != ' '){
                count[3] = 1;
            }
        }
        if(count[0] + count[1] + count[2] + count[3] < 3) {
            return "NG";
        }

        // 重复子串
        String tempStr;
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < str.length() - 1; i++) {
            tempStr = str.substring(i, i + 2);
            if (map.get(tempStr) != null) {
                if(map.get(tempStr) != i) {
                    return "NG";
                } else {
                    map.put(tempStr, i + 1);
                }
            } else {
                map.put(tempStr, i + 1);
            }
        }

        return "OK";

    }


}
