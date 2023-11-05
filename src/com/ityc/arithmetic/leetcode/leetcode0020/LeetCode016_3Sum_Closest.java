package com.ityc.arithmetic.leetcode.leetcode0020;

import java.util.Arrays;

/**
 * ac:100% 最接近的三数之和
 * 思路：遍历的话，会是O(N^3),会超时，所以遍历一遍数组，然后使用双指针减少另外两次遍历。
 *     主要问题：使用双指针可以优化遍历，而且不会漏掉任何一种情况
 * @author yuchao
 * @Date 2023/11/5 16:38
 **/
public class LeetCode016_3Sum_Closest {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        // 临时变量，用来记录数组下标（双指针）
        int x,y;
        // result——最接近targetd的三数之和;gap = |target - result|;
        int result = Integer.MAX_VALUE, gap = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++) {
            x = i + 1;
            y = nums.length - 1;
            while (y - x > 0) {

                int abs = Math.abs(nums[i] + nums[x] + nums[y] - target);
                if (abs < gap) {
                    gap = abs;
                    result = nums[i] + nums[x] + nums[y];
                }

                if (nums[i] + nums[x] + nums[y] > target) {
                    y--;
                } else if (nums[i] + nums[x] + nums[y] < target) {
                    x++;
                } else {
                    return target;
                }
            }
        }
        return result;
    }


}
