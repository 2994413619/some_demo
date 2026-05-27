package com.ityc.arithmetic.niuke;

import java.util.HashSet;

/**
 * 数组中重复的数字
 * @author 喻超
 * @date 2019年11月3日 上午12:00:03
 * @Description ac:100%
 *
 */
public class A50_Find_Repeat_Number_In_Array {

	public boolean duplicate(int numbers[], int length, int[] duplication) {
		HashSet<Integer> set = new HashSet<Integer>();
		for(int i = 0; i < length; i++) {
			if(set.contains(numbers[i])) {
				duplication[0] = numbers[i];
				return true;
			} else {
				set.add(numbers[i]);
			}
		}
		return false;
	}

}
