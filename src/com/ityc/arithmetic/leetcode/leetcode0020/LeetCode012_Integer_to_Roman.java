package com.ityc.arithmetic.leetcode.leetcode0020;

/**
 * @Author yuchao
 * @Description 整数转罗马数字（第12题）
 *              ac:100%
 * @Date 2021/03/29 14:23
 **/
public class LeetCode012_Integer_to_Roman {
    class Solution {
        public String intToRoman(int num) {
            StringBuilder str = new StringBuilder();
            switch (num){
                case 4 : return "IV";
                case 9 : return "IX";
                case 40 : return "XL";
                case 90 : return "XC";
                case 400 : return "CD";
                case 900 : return "CM";
            }
            int size = 0;
            if(num >= 1000) {
                size = num /1000;
                for(int i = 0; i < size; i++){
                    str.append('M');
                }
                num %= 1000;
            }
            if(num >= 900) {
                str.append("CM");
                num -= 900;
            }
            if(num >= 500){
                size = num / 500;
                for(int i = 0; i < size; i++){
                    str.append('D');
                }
                num %= 500;
            }
            if(num >= 400) {
                str.append("CD");
                num -= 400;
            }
            if(num >= 100){
                size = num / 100;
                for(int i = 0; i < size; i++){
                    str.append('C');
                }
                num %= 100;
            }
            if(num >= 90) {
                str.append("XC");
                num -= 90;
            }
            if(num >= 50){
                size = num / 50;
                for(int i = 0; i < size; i++){
                    str.append('L');
                }
                num %= 50;
            }
            if(num >= 40) {
                str.append("XL");
                num -= 40;
            }
            if(num >= 10){
                size = num / 10;
                for(int i = 0; i < size; i++){
                    str.append('X');
                }
                num %= 10;
            }
            if(num == 9) {
                str.append("IX");
                num -= 9;
            }
            if(num >= 5){
                size = num / 5;
                for(int i = 0; i < size; i++){
                    str.append('V');
                }
                num %= 5;
            }
            if(num == 4) {
                str.append("IV");
                num -= 4;
            }
            if(num > 0){
                for(int i = 0; i < num; i++){
                    str.append('I');
                }
            }
            return str.toString();
        }
    }
}
