package com.ityc.arithmetic.niuke;

/**
 * 数字在排序数组中出现的次数
 * @author 喻超
 * @date 2019年9月12日 下午1:23:24
 * @Description ac:100%
 *
 */
public class A37_Array_ {

	public int GetNumberOfK(int[] array, int k) {
		int count = 0;
		for(int i = 0; i < array.length; i++) {
			if(k == array[i]) {
				count++;
			}
		}
		
		return count;
	}

}
/*
 * 题目描述 统计一个数字在排序数组中出现的次数。
 */