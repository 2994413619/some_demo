package com.ityc.arithmetic.leetcode.leetcode0100;

import com.ityc.arithmetic.leetcode.pojo.ListNode;

/**
 * ac:100% �ָ�����
 * ˼·����������<x�Ľڵ����ƣ���¼�����ұߵ�<x��λ�ã����������У������ǰλ�ú�Ҫ�ƶ���λ��һ�������ƶ�
 * @author yuchao
 * @Date 2023/11/5 20:17
 **/
public class LeetCode086_Partition_List {
    public ListNode partition(ListNode head, int x) {
        ListNode breakPoint = null; // ��¼���ұߵ�С��x�Ľڵ�
        ListNode resultHead = head; // ������ͷ�ڵ�
        ListNode node = head; // �����ĵ�ǰ�ڵ�
        ListNode preNode = null; // ��������һ���ڵ�
        while (node != null) {
            if (node.val < x) { // <x�����ƽڵ�
                if(breakPoint == null) { // ��ǰ�ڵ��ǵ�һ��С��x�Ľڵ�
                    breakPoint = node;
                    resultHead = node;

                    // ��ǰ�ڵ㲻�ǵ�һ���ڵ㣬���ƶ�����֮���ƶ�
                    if(preNode != null) {
                        preNode.next = node.next;
                        node.next = head;
                        // �α����
                        node = preNode.next;
                    } else {
                        // �α����
                        preNode = node;
                        node = node.next;
                    }

                } else { // ��ǰ�ڵ㲻�ǵ�һ��С��x�Ľڵ�
                    // �ƶ��ڵ� ��ǰλ�ú�Ҫ�ƶ���λ�ò���ͬһλ��
                    if (breakPoint.next == null || !breakPoint.next.equals(node)) {
                        preNode.next = node.next;
                        node.next = breakPoint.next;
                        breakPoint.next = node;
                        // ��¼���ұ�С��x�Ľڵ�λ��
                        breakPoint = node;
                        // �α����
                        node = preNode.next;
                    } else {
                        // ��¼���ұ�С��x�Ľڵ�λ��
                        breakPoint = node;
                        // �α����
                        node = node.next;
                    }

                }
            } else { // >=x����������������ֱ���α����
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
