package com.ityc.arithmetic.leetcode.leetcode0960;

import java.util.Stack;

/**
 * 验证栈序列 ac:100%
 * @author yuchao
 * @date 2023/11/17 16:22
 **/
public class LeetCode946_Validate_Stack_Sequences {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int j = 0;
        for (int i : pushed) {
            stack.push(i);
            // 判断stack顶元素是否和pupped前面的元素相等；相等则popped指针后移，并stack.pop
            while (stack.size() > 0 && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            }
        }
        return stack.size() == 0;
    }

}
