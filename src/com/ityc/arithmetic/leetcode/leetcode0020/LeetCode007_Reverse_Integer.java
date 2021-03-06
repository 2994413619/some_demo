package com.ityc.arithmetic.leetcode.leetcode0020;

import org.junit.Test;

/**
 * @author yuchao
 * @date 2020/1/29 19:09
 * @description ac:100%
 */
public class LeetCode007_Reverse_Integer {
    public int reverse(int x) {
        if(x == 0){
            return 0;
        }
        String string = "";
        int number = x;
        if(x < 0){
            number = Math.abs(x);
            string += "-";
        }

        StringBuilder stringBuilder = new StringBuilder(number + "");
        StringBuilder reverse = stringBuilder.reverse();
        String s = reverse.toString();
        while(s.length() > 1 && s.startsWith("0")){
            s = s.substring(1, s.length());
        }
        try{
            return Integer.parseInt(string + s);
        } catch (NumberFormatException e){
            return 0;
        }
    }

    @Test
    public  void test(){
        System.out.println(reverse(1534236469));
    }

}
/*
* 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。

示例 1:

输入: 123
输出: 321
 示例 2:

输入: -123
输出: -321
示例 3:

输入: 120
输出: 21
注意:

假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/reverse-integer
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/