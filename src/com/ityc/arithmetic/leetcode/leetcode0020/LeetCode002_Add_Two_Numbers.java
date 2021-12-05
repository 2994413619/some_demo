package com.ityc.arithmetic.leetcode.leetcode0020;

import com.ityc.arithmetic.leetcode.pojo.ListNode;
import org.junit.Test;

/**
 * @author yuchao
 * @description ac:100%
 * @date 2019/12/17 23:27
 */
public class LeetCode002_Add_Two_Numbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node1 = l1, node2 = l2;    //两个链表的指针
        boolean isHead = true;              //判断是否当前创建的是否为头结点
        int add = 0;                        //当前位的和
        int next = 0;                       //进位值
        ListNode head = null,node = null;   //头结点和尾节点
        while(node1 != null || node2 != null || next != 0){         //跳出循环的条件，两个链表都遍历完并且没有进位

            add = 0;

            //计算当前位相加的和并指针向后移
            if(node1 != null){
                add = node1.val;
                node1 = node1.next;
            }
            if(node2 != null){
                add += node2.val;
                node2 = node2.next;
            }
            add += next;

            //创建节点
            if(isHead){
                node = new ListNode(add % 10);
                head = node;

                isHead = false;
            } else{
                node.next = new ListNode(add % 10);
                node = node.next;
            }
            next = add / 10;
        }
        return head;
    }

    @Test
    public void test(){
        System.out.println(addTwoNumbers(new ListNode(5),new ListNode(5)).val);
    }
}
/**
 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。

 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。

 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。

 示例：

 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 输出：7 -> 0 -> 8
 原因：342 + 465 = 807
 */