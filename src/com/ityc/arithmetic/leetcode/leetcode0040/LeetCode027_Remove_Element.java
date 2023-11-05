package com.ityc.arithmetic.leetcode.leetcode0040;

/**
 * ac:100% �Ƴ�Ԫ��
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
            // �����������ǰ�ƶ�
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
