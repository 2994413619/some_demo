package com.ityc.arithmetic.leetcode.leetcode0100;

import com.ityc.arithmetic.leetcode.pojo.ListNode;

/**
 * ac:100% 分隔链表
 * 思路：遍历链表，<x的节点左移，记录下最右边的<x的位置；遍历过程中，如果当前位置和要移动的位置一样，则不移动
 * @author yuchao
 * @Date 2023/11/5 20:17
 **/
public class LeetCode086_Partition_List {
    public ListNode partition(ListNode head, int x) {
        ListNode breakPoint = null; // 记录最右边的小于x的节点
        ListNode resultHead = head; // 重组后的头节点
        ListNode node = head; // 遍历的当前节点
        ListNode preNode = null; // 遍历的上一个节点
        while (node != null) {
            if (node.val < x) { // <x，左移节点
                if(breakPoint == null) { // 当前节点是第一个小于x的节点
                    breakPoint = node;
                    resultHead = node;

                    // 当前节点不是第一个节点，则移动；反之不移动
                    if(preNode != null) {
                        preNode.next = node.next;
                        node.next = head;
                        // 游标后移
                        node = preNode.next;
                    } else {
                        // 游标后移
                        preNode = node;
                        node = node.next;
                    }

                } else { // 当前节点不是第一个小于x的节点
                    // 移动节点 当前位置和要移动的位置不是同一位置
                    if (breakPoint.next == null || !breakPoint.next.equals(node)) {
                        preNode.next = node.next;
                        node.next = breakPoint.next;
                        breakPoint.next = node;
                        // 记录最右边小于x的节点位置
                        breakPoint = node;
                        // 游标后移
                        node = preNode.next;
                    } else {
                        // 记录最右边小于x的节点位置
                        breakPoint = node;
                        // 游标后移
                        node = node.next;
                    }

                }
            } else { // >=x，不做其他操作，直接游标后移
                preNode = node;
                node = node.next;
            }
        }
        return resultHead;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        LeetCode086_Partition_List instance = new LeetCode086_Partition_List();
        ListNode partition = instance.partition(head, 2);
        System.out.println("yyy");
    }

}
