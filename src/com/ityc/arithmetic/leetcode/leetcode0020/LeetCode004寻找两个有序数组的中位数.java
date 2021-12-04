package com.ityc.arithmetic.leetcode.leetcode0020;

import java.util.ArrayList;

/**
 * @author yuchao
 * @date 2019/12/22 22:57
 * @description ac:100%
 */
public class LeetCode004寻找两个有序数组的中位数 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        int i = 0, j = 0;
        while(i < nums1.length || j < nums2.length){
            if(i < nums1.length && j < nums2.length){
                if(nums1[i] < nums2[j]){
                    list.add(nums1[i]);
                    i++;
                } else {
                    list.add((nums2[j]));
                    j++;
                }
            } else if(i < nums1.length) {
                list.add(nums1[i]);
                i++;
            } else {
                list.add((nums2[j]));
                j++;
            }
        }

        if(list.size() % 2 == 0){
            int center = list.size() / 2;
            return (double) (list.get(center) + list.get(center - 1)) / 2;
        } else {
            return list.get(list.size() / 2);
        }

    }

}
/*
* 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。

请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。

你可以假设 nums1 和 nums2 不会同时为空。

示例 1:

nums1 = [1, 3]
nums2 = [2]

则中位数是 2.0
示例 2:

nums1 = [1, 2]
nums2 = [3, 4]

则中位数是 (2 + 3)/2 = 2.5
*/