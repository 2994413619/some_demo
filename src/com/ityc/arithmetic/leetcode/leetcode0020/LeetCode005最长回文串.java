package com.ityc.arithmetic.leetcode.leetcode0020;

import org.junit.Test;

import java.util.ArrayList;

/**
 * @author yuchao
 * @date 2020/01/29 16:40
 * @description ac:100%
 */
public class LeetCode005最长回文串 {
    public String longestPalindrome(String s) {
        if(s == null){
            return null;
        }
        if("".equals(s)){
            return  "";
        }
        if(s.length() == 1){
            return s;
        }

        int len1 = 0, len2 = 0;
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        ArrayList<Integer> list2 = new ArrayList<Integer>();

        //找出所有长度为2的子串
        for(int i = 0; i < s.length() - 1; i++){
            if(s.charAt(i) == s.charAt(i + 1)){
                list1.add(i);
            }
        }
        len1 = list1.size() == 0 ? 0 : 2;

        //以长度为2的所有子串为基础找长度为4的子串，然后以长度为4的。。。
        while(list1.size() != 0 && len1 + 2 <= s.length()){
            ArrayList<Integer> listTemp = new ArrayList<>();
            for(int temp : list1){
                if(temp - 1 >= 0 && (temp + len1) < s.length()){//向左右延伸的字符下标没有超过[0，length]
                    if(s.charAt(temp - 1) == s.charAt(temp + len1)){//左右字符相同
                        listTemp.add(temp - 1);
                    }
                }
            }
            if(listTemp.size() > 0){
                len1 += 2;
                list1 = listTemp;
            } else {
                break;
            }
        }

        //找到长度为3的所有子串
        for(int i = 1; i < s.length() - 1; i++){
            if(s.charAt(i - 1) == s.charAt(i + 1)){
                list2.add(i - 1);
            }
        }
        len2 = list2.size() == 0 ? 0 : 3;

        //以长度为3的所有子串为基础找长度为5的子串，然后以长度为5的。。。
        while(list2.size() != 0 && len2 + 2 <= s.length()){
            ArrayList<Integer> listTemp = new ArrayList<>();
            for(int temp : list2){
                if(temp - 1 >= 0 && (temp + len2) < s.length()){//向左右延伸的字符下标没有超过[0，length]
                    if(s.charAt(temp - 1) == s.charAt(temp + len2)){//左右字符相同
                        listTemp.add(temp - 1);
                    }
                }
            }
            if(listTemp.size() > 0){
                len2 += 2;
                list2 = listTemp;
            } else {
                break;
            }
        }

        if(len1 == 0 && len2 == 0){
            return s.substring(0, 0);
        }

        if(len1 > len2){
            return s.substring(list1.get(0), list1.get(0) + len1);
        } else {
            return s.substring(list2.get(0), list2.get(0) + len2);
        }

    }

    @Test
    public void test(){
        String ccc = longestPalindrome("ccc");
        System.out.println(ccc);
    }

}
/**
 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。

 示例 1：

 输入: "babad"
 输出: "bab"
 注意: "aba" 也是一个有效答案。
 示例 2：

 输入: "cbbd"
 输出: "bb"
 */