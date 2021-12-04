package com.ityc.arithmetic.leetcode.leetcode0020;

import org.junit.Test;

/**
 * @author yuchao
 * @date 2019/12/22 22:52
 * @description ac:100%
 * 思路：设置字符串变量 temp为""，遍历字符串s，去除当前字符c，如果temp中没有c，则temp += c；如果temp中有c，则把下标为0~第一次出现c的字符串从temp中移出。
 *       每次，temp变动，记录最大字符串值max
 */
public class LeetCode003无重复字符的最长子串 {

    public int lengthOfLongestSubstring(String s) {
        String temp = "";
        int max = 0;

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(temp.indexOf("" + c) == -1){
                temp += c;
                max = temp.length() > max ? temp.length() : max;
            } else {
                temp = temp.substring(temp.indexOf("" + c) + 1);
                temp += c;
            }
        }

        return max;
    }

    @Test
    public void test(){
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }


}
/**
 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

 示例 1:

 输入: "abcabcbb"
 输出: 3
 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 示例 2:

 输入: "bbbbb"
 输出: 1
 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 示例 3:

 输入: "pwwkew"
 输出: 3
 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */