package com.ityc.arithmetic.leetcode.leetcode0340;

import org.junit.Test;

/**
 * @author yuchao
 * @date 2020/3/11 16:30
 * @description ac:100%
 * 动态规划（最值问题）
 */
public class LeetCode322_Coin_Change {
    public int coinChange(int[] coins, int amount) {
        int[] result = new int[amount + 1];

        //设置初始值
        result[0] = 0;
        for(int i = 1; i < result.length; i++){//i表示总金额
            //设置初始值
            result[i] = Integer.MAX_VALUE;
            for(int j = 0; j < coins.length; j++){
                //组合不了(总金额减去一个硬币后小于0 || 减去一个硬币后的总金额无法组合)
                if(i - coins[j] < 0 || result[i - coins[j]] == Integer.MAX_VALUE){
                    continue;
                }
                result[i] = result[i] < (result[i - coins[j]] + 1) ? result[i] : (result[i - coins[j]] + 1);
            }
        }

        //不能组合
        if(result[amount] == Integer.MAX_VALUE){
            return -1;
        }
        return result[amount];
    }

    @Test
    public void test(){
        int i = coinChange(new int[]{2, 5, 10, 1}, 27);
        System.out.println(i);
    }

}
/**
 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。

 示例 1:

 输入: coins = [1, 2, 5], amount = 11
 输出: 3
 解释: 11 = 5 + 5 + 1
 示例 2:

 输入: coins = [2], amount = 3
 输出: -1
 说明:
 你可以认为每种硬币的数量是无限的。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/coin-change
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */