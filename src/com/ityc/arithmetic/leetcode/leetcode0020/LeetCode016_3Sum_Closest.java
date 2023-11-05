package com.ityc.arithmetic.leetcode.leetcode0020;

import java.util.Arrays;

/**
 * ac:100% ��ӽ�������֮��
 * ˼·�������Ļ�������O(N^3),�ᳬʱ�����Ա���һ�����飬Ȼ��ʹ��˫ָ������������α�����
 *     ��Ҫ���⣺ʹ��˫ָ������Ż����������Ҳ���©���κ�һ�����
 * @author yuchao
 * @Date 2023/11/5 16:38
 **/
public class LeetCode016_3Sum_Closest {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        // ��ʱ������������¼�����±꣨˫ָ�룩
        int x,y;
        // result������ӽ�targetd������֮��;gap = |target - result|;
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
