package com.ityc.arithmetic.leetcode.leetcode0040;

/**
 * ac:100% 移除元素
 * @author yuchao
 * @Date 2023/11/5 17:21
 **/
public class LeetCode027_Remove_Element {

    public int removeElement(int[] nums, int val) {
        if (val > 50) {
            return nums.length;
        }

        int realIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            // 后面的数字向前移动
            if (i != realIndex && nums[i] != val) {
                nums[realIndex] = nums[i];
            }
            if (nums[i] != val) {
                realIndex++;
            }

        }
        return realIndex;
    }

}
