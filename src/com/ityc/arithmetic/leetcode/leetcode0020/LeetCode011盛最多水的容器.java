package com.ityc.arithmetic.leetcode.leetcode0020;

/**
 * @author yuchao
 * @date 2020/3/9 13:01
 * @description ac:100%
 * 方法：双指针法
 */
public class LeetCode011盛最多水的容器 {
    public int maxArea(int[] height) {
          int a = 0, b = height.length - 1;
          int area = 0,flag;
          while(a < b){
              flag = (b - a) * (height[a] > height[b] ? height[b] : height[a]);
              area = area > flag ? area : flag;
              if(height[a] > height[b]){
                  b--;
              } else {
                  a++;
              }
          }
          return area;
    }
}
/**
 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。

 说明：你不能倾斜容器，且 n 的值至少为 2。

  
 此处少一张图片，可以点下面链接查看原题。


 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。

  

 示例：

 输入：[1,8,6,2,5,4,8,3,7]
 输出：49

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/container-with-most-water
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */