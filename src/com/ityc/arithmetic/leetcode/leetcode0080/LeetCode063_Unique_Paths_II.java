package com.ityc.arithmetic.leetcode.leetcode0080;

/**
 * @author yuchao
 * @date 2020/3/11 17:35
 * @description ac:100%
 */
public class LeetCode063_Unique_Paths_II {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] result = new int[obstacleGrid.length][obstacleGrid[0].length];
        //为第一行赋值
        if(obstacleGrid[0][0] == 0){
            result[0][0] = 1;
        } else {
            result[0][0] = 0;
        }
        for(int i = 1; i < result[0].length; i++){
            if(obstacleGrid[0][i] == 0){
                result[0][i] = result[0][i - 1];
            } else {
                result[0][i] = 0;
            }
        }
        //为第一列赋值
        for(int i = 1; i < result.length; i++){
            if(obstacleGrid[i][0] == 0){
                result[i][0] = result[i - 1][0];
            } else {
                result[i][0] = 0;
            }
        }
        //为剩下的赋值
        for(int i = 1; i < result.length; i++){
            for(int j = 1; j < result[0].length; j++){
                if(obstacleGrid[i][j] == 0){
                    result[i][j] = result[i][j - 1] + result[i - 1][j];
                } else {
                    result[i][j] = 0;
                }
            }
        }
        return result[result.length - 1][result[0].length - 1];
    }
}
/**
 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。

 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。

 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？



 网格中的障碍物和空位置分别用 1 和 0 来表示。

 说明：m 和 n 的值均不超过 100。

 示例 1:

 输入:
 [
   [0,0,0],
   [0,1,0],
   [0,0,0]
 ]
 输出: 2
 解释:
 3x3 网格的正中间有一个障碍物。
 从左上角到右下角一共有 2 条不同的路径：
 1. 向右 -> 向右 -> 向下 -> 向下
 2. 向下 -> 向下 -> 向右 -> 向右

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/unique-paths-ii
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */