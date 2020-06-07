/*
 * Miya.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package org.lsz.util;

/**
 * @author liushuangzeng
 * @Date 20/6/6 下午8:18
 */
public class ListNode {

    public int val;

    public ListNode next;

    public ListNode() {
    }

    public ListNode(int data) {
        this.val = data;
    }

    public void printListNode() {
        ListNode h = this;
        while (h != null) {
            System.out.print(h.val + " -> ");
            h = h.next;
        }
        System.out.print("null");
    }
}