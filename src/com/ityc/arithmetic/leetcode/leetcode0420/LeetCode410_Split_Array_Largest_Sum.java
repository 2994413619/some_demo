package com.ityc.arithmetic.leetcode.leetcode0420;

/**
 * @author yuchao
 * @date 2019/09/05 20:33
 * @description ac:100%
 */
public class LeetCode410_Split_Array_Largest_Sum {
    public int splitArray(int[] nums, int m) {
        int n = nums.length;
        int[][] dp =  new int[m + 1][n + 1];
        int[] sub = new int[n + 1];
        //为dp赋初值
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        //计算累加数组sub的值
        for(int i = 0; i < n; i++) {
            sub[i + 1] = sub[i] + nums[i];
        }

        //为数组dp赋值
        for(int i = 1;i <= m; i++) {//分组数
            for(int j = 1; j <= n;j++) {//数组长度
                for(int k = i - 1;k <= j - 1; k++) {//上一组最后一个元素的index

                    if(i == 1) {
                        dp[i][j] = sub[j];
                    } else {
                        dp[i][j] = Math.min(dp[i][j],Math.max(dp[i - 1][k],sub[j] - sub[k]));
                    }

                }
            }
        }

        return dp[m][n];
    }
}
/**
 * 给定一个非负整数数组和一个整数 m，你需要将这个数组分成 m 个非空的连续子数组。设计一个算法使得这 m 个子数组各自和的最大值最小。
 *
 * 注意:
 * 数组长度 n 满足以下条件:
 *
 * 1 ≤ n ≤ 1000
 * 1 ≤ m ≤ min(50, n)
 * 示例:
 *
 * 输入:
 * nums = [7,2,5,10,8]
 * m = 2
 *
 * 输出:
 * 18
 *
 * 解释:
 * 一共有四种方法将nums分割为2个子数组。
 * 其中最好的方式是将其分为[7,2,5] 和 [10,8]，
 * 因为此时这两个子数组各自的和的最大值为18，在所有情况中最小。
 * */