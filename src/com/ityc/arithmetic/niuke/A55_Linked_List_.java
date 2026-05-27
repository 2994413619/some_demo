package com.ityc.arithmetic.niuke;

import java.util.HashSet;

/**
 * 链表中环的入口结点
 * @author 喻超
 * @date 2019年11月3日 下午12:45:26
 * @Description ac:100%
 *
 */
public class A55_Linked_List_ {

	public ListNode EntryNodeOfLoop(ListNode pHead) {
		
		if(pHead == null) {
			return null;
		}
		
		HashSet<ListNode> set = new HashSet<ListNode>();
		set.add(pHead);
		ListNode node = pHead.next;
		while(node != null) {
			if(!set.contains(node)) {
				set.add(node);
			} else {
				return node;
			}
			node = node.next;
		}
		return null;
	}

}
/**
 * 题目描述 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 */