package com.ityc.arithmetic.leetcode.leetcode0900;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 有序队列 ac:100%
 * @author yuchao
 * @Date 2023/11/16 20:42
 **/
public class LeetCode899_Orderly_Queue {

    public String orderlyQueue(String s, int k) {
        if(k > 1) {
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            return String.valueOf(charArray);
        } else {
            char temp = 'z' + 1;// 记录最小的字符
            int index = s.length();
            List<Integer> indexs = new ArrayList<>();
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) < temp) {
                    temp = s.charAt(i);
                    index = i;
                    indexs.clear();
                    indexs.add(index);
                } else if (s.charAt(i) == temp) { //如果有多个最小的字符，记录下所有字符的index
                    indexs.add(i);

                }
            }
            if (indexs.size() == 0) {// 如果只有一个最小的字母，则直接返回；
                return s.substring(index) + s.substring(0, index);
            } else {
                String minStr = null, tempStr;
                for(Integer ind : indexs) {
                    tempStr = s.substring(ind) + s.substring(0, ind);
                    if(minStr == null) {
                        minStr = tempStr;
                    } else {
                        minStr = min(tempStr, minStr);
                    }
                }
                return minStr;
            }
        }
    }

    public String min(String str, String str2) {
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) > str2.charAt(i)) {
                return str2;
            } else if (str.charAt(i) < str2.charAt(i)) {
                return str;
            }
        }
        return str;
    }

    public static void main(String[] args) {
        LeetCode899_Orderly_Queue instance = new LeetCode899_Orderly_Queue();
        String str = instance.orderlyQueue("xitavoyjqiupzadbdyymyvuteolyeerecnuptghlzsynozeuuvteryojyokpufanyrqqmtgxhyycltlnusyeyyqygwupcaagtkuq", 1);
        System.out.println(str);
    }

}
