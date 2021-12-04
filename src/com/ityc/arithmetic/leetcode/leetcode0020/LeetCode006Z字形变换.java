package com.ityc.arithmetic.leetcode.leetcode0020;

import org.junit.Test;

/**
 * @author yuchao
 * @date 2020/1/29 17:18
 * @description ac:100%
 */
public class LeetCode006Z字形变换 {
    public String convert(String s, int numRows) {
        if(numRows == 1){
            return s;
        }

        //1、计算一维的长度，构建字符数组
        int column = 1;
        if(s.length() > numRows){
            int unit = numRows + numRows - 2;
            int temp = s.length() - numRows;
            int size = temp / unit;
            column += size * (numRows - 1);
            int remainder = temp % unit;
            if(remainder <= (numRows - 2)){
                column += remainder;
            } else {
                column += numRows - 1;
            }
        }
        char[][] arr = new char[numRows][column];
        for(int i = 0; i < numRows; i++){
            for(int j = 0; j < column; j++){
                arr[i][j] = '#';
            }
        }
        //2、从新构建字符串，返回结果
        int i = 0, j = -1,index = 0;
        first:while(true){
            j++;
            //向下,循环numRows次
            for(i = 0; i < numRows; i++){
                if(index < s.length()){
                    arr[i][j] = s.charAt(index++);
                } else {
                    break first;
                }
            }
            i--;
            //斜向上，循环numRows - 2次
            for(int x = 0; x < numRows - 2; x++){
                if(index < s.length()){
                    arr[--i][++j] = s.charAt(index++);
                } else {
                    break first;
                }
            }
        }

        StringBuilder result = new StringBuilder();

        for(int m = 0; m < numRows; m++){
            for(int n = 0; n < column; n++){
                if(arr[m][n] != '#'){
                    result.append(arr[m][n]);
                }
            }
        }

        return result.toString();
    }

    @Test
    public  void test(){
        String s = convert("PAYPALISHIRING", 3);
        System.out.println(s);
    }
}
/**
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 *
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 *
 * 请你实现这个将字符串进行指定行数变换的函数：
 *
 * string convert(string s, int numRows);
 * 示例 1:
 *
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 * 示例 2:
 *
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * 解释:
 *
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zigzag-conversion
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */