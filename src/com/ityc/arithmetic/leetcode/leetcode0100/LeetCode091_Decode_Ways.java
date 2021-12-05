package com.ityc.arithmetic.leetcode.leetcode0100;

/**
 * @author yuchao
 * @date 2020/3/12 16:29
 * @description ac:100%
 * 序列型动态规划
 */
public class LeetCode091_Decode_Ways {
    public int numDecodings(String s) {
        int[] result = new int[s.length() + 1];
        result[0] = 1;
        if(s.length() >= 1){
            //第一个字母为0无法解码
            if(s.charAt(0) == '0'){
                return 0;
            }
            result[1] = 1;
        }
        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i - 1) == '0' || s.charAt(i - 1) > '2'){
                if(s.charAt(i) == '0'){
                    return 0;
                } else {
                    result[i + 1] = result[i];
                }
            } else if(s.charAt(i - 1) == '2'){ //第i- 1位是2
                if(s.charAt(i) == '0'){
                    result[i + 1] = result[i - 1];
                } else if(s.charAt(i) <= '6'){
                    result[i + 1] = result[i] + result[i - 1];
                } else {
                    result[i + 1] = result[i];
                }
            } else {//第i - 1位是1
                if(s.charAt(i) == '0'){
                    result[i + 1] = result[i - 1];
                } else {
                    result[i + 1] = result[i] + result[i - 1];
                }
            }
        }
        return result[s.length()];
    }
}
/**
 一条包含字母 A-Z 的消息通过以下方式进行了编码：

 'A' -> 1
 'B' -> 2
 ...
 'Z' -> 26
 给定一个只包含数字的非空字符串，请计算解码方法的总数。

 示例 1:

 输入: "12"
 输出: 2
 解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
 示例 2:

 输入: "226"
 输出: 3
 解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/decode-ways
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */