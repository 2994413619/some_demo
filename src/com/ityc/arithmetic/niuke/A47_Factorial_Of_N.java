package com.ityc.arithmetic.niuke;

/**
 * 求n的阶乘
 * @author 喻超
 * @date 2019年10月28日 下午11:17:32
 * @Description ac:100%
 *
 */
public class A47_Factorial_Of_N {

	public int Sum_Solution(int n) {
        return n == 1 ? 1 : Sum_Solution(n - 1) + n;
    }
	
}
/**

题目描述
求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
*/