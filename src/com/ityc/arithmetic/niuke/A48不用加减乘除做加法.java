package com.ityc.arithmetic.niuke;

/**
 * 
 * @author 喻超
 * @date 2019年11月1日 下午11:32:13
 * @Description ac:100%
 * 解题思路：
 * 1、把两个数转换为二进制来处理，使用& ^ | <<运算符。假设A + B = C
 * 2、使用& ^ |的意义：
 * 	A & B的结果：1表示需要进位的位，0表示不需要进位的位
 * 	A ^ B的结果：1表示不需要进位的位
 * 	A | B的结果：得到两个数不进位相加的结果 
 * 3、当A + B正好每位都不需要进位的时候：C = A | B
 * 4、当A + B有需要进位的位的时候：设：
 * 	n1 = A ^ B
 *  n2 = (A & B) << 1
 * 5、A + B = n1 + n2
 * 6、重复3、4，直到 n1 & n2 == 0(表示没有需要进位的位的时候，返回n1 | n2)
 * 
 *
 */
public class A48不用加减乘除做加法 {

	public int Add(int num1, int num2) {
		if((num1 & num2) == 0) {
			return num1 | num2;
		}
		
		int n1 = num1 ^ num2,n2 = (num1 & num2) << 1;
		
		while((n1 & n2) != 0) {
			num1 = n1 ^ n2;
			num2 = (n1 & n2) << 1;
			n1 = num1;
			n2 = num2;
		}
		
		return n1 | n2;
	}
	
}
/**
题目描述
写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
*/