package com.ityc.arithmetic.leetcode.leetcode0660;

/**
 * 设计循环双端队列 ac:100%
 * @author yuchao
 * @Date 2023/11/16 19:04
 **/
public class LeetCode641_Design_Circular_Deque {

    private int size = 0;
    public int maxSize;

    private Node head = null;

    private Node end = null;


    public LeetCode641_Design_Circular_Deque(int k) {
        maxSize = k;
    }

    public boolean insertFront(int value) {
        if (size == maxSize) {
            return false;
        }
        Node node = new Node(value);
        if (size != 0) {
            node.next = head;
            head.front = node;
            head = node;
        } else {
            head = node;
            end = node;
        }
        size++;
        return true;
    }

    public boolean insertLast(int value) {
        if (size == maxSize) {
            return false;
        }
        Node node = new Node(value);
        if (size != 0) {
            end.next = node;
            node.front = end;
            end = node;
        } else {
            head = node;
            end = node;
        }
        size++;
        return true;
    }

    public boolean deleteFront() {
        if (size <= 0) {
            return false;
        }

        head = head.next;
        if (head != null) {
            head.front = null;
        }

        size--;
        return true;
    }

    public boolean deleteLast() {
        if (size <= 0) {
            return false;
        }

        end = end.front;
        if ( end != null) {
            end.next = null;
        }

        size--;
        return true;
    }

    public int getFront() {
        if (size <= 0) {
            return -1;
        }
        return head.value;
    }

    public int getRear() {
        if (size <= 0) {
            return -1;
        }
        return end.value;
    }

    public boolean isEmpty() {
        if (size <= 0) {
            return true;
        }
        return false;
    }

    public boolean isFull() {
        if (size == maxSize) {
            return true;
        }
        return false;
    }

}

class Node {
    int value;
    Node front;
    Node next;

    public Node(int val) {
        value = val;
    }
}
