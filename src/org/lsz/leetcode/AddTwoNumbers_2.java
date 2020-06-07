/*
 * Miya.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package org.lsz.leetcode;

import org.lsz.util.ListNode;

/**
 * @author liushuangzeng
 * @Date 20/6/7 上午9:41
 */
public class AddTwoNumbers_2 {

    ListNode h1;

    ListNode h2;

    public AddTwoNumbers_2() {
        h1 = new ListNode(2);
        ListNode l1 = new ListNode(4);
        ListNode l2 = new ListNode(3);
        h1.next = l1;
        l1.next = l2;

        h2 = new ListNode(5);
        ListNode r1 = new ListNode(6);
        ListNode r2 = new ListNode(4);
        ListNode r3 = new ListNode(8);
        h2.next = r1;
        r1.next = r2;
        r2.next = r3;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode emptyHead = new ListNode();
        ListNode current = emptyHead;
        int last = 0;
        while (l1 != null || l2 != null) {
            int l1Val = l1 == null ? 0 : l1.val;
            int l2Val = l2 == null ? 0 : l2.val;

            int sum = l1Val + l2Val + last;
            last = sum / 10;

            current.next = new ListNode(sum % 10);

            current = current.next;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        if (last > 0) {
            current.next = new ListNode(last);
        }
        return emptyHead.next;
    }

    public static void main(String[] args) {
        AddTwoNumbers_2 addTwoNumbers = new AddTwoNumbers_2();
        addTwoNumbers.h1.printListNode();
        addTwoNumbers.h2.printListNode();
        addTwoNumbers.addTwoNumbers(addTwoNumbers.h1, addTwoNumbers.h2).printListNode();
    }
}