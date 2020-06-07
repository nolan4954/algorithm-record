/*
 * Miya.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package org.lsz.leetcode;

import org.lsz.util.ListNode;

/**
 * 反转链表
 * @author liushuangzeng
 * @Date 20/6/6  下午8:17
 */
public class ReverseList_206 {

    ListNode myHead;

    public ReverseList_206() {
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(4);
        listNode.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;

        myHead = listNode;
    }

    /**
     * 就地反转
     * time complexity: O(n)
     * space complexity: O(1)
     * @param head
     * @return
     */
    public ListNode reverseList1(ListNode head) {
        ListNode h = null;
        ListNode current = head;
        ListNode temp = null;

        while (current != null) {
            temp = current.next;
            current.next = h;
            h = current;
            current = temp;
        }

        return h;
    }

    /**
     * 比较好理解的递归
     * time complexity: O(n)
     * space complexity: O(n)
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        ListNode h = new ListNode();
        ListNode tail = recursive(head, h);
        return h.next;
    }

    /**
     * 利用栈，去遍历，挨个反转 本节点与下个节点的 指向
     * time complexity: O(n)
     * space complexity: O(n)
     *
     * @param head
     * @return
     */
    public ListNode reverseList3(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode tail = reverseList3(head.next);
        ListNode next = head.next;
        next.next = head;
        head.next = null;

        return tail;
    }

    public ListNode recursive(ListNode head, ListNode h) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            h.next = head;
            return head;
        }
        ListNode tail = recursive(head.next, h);
        tail.next = head;
        head.next = null;
        return head;
    }



    public static void main(String[] args) {
        ReverseList_206 main = new ReverseList_206();

//        main.reverseList1(main.myHead).printListNode();

//        main.reverseList2(main.myHead).printListNode();

        main.reverseList3(main.myHead).printListNode();
    }
}