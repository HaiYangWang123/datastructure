package com.hywang.leetcode.chapter_2;

import com.sun.org.apache.regexp.internal.RE;

import java.util.Stack;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例：
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class Solution {
    public static void main(String[] args) {
        ListNode ln1 = new ListNode(2);
        ListNode ln2 = new ListNode(4);
        ListNode ln3 = new ListNode(7);
        ln1.next = ln2;
        ln2.next = ln3;
        ListNode ln4 = new ListNode(3);
        ListNode ln5 = new ListNode(5);
        ListNode ln6 = new ListNode(9);
        ln4.next = ln5;
        ln5.next = ln6;

        ListNode listNode = addTwoNumbers(ln1, ln4);
         while (listNode!=null){
             System.out.println(listNode.val);
             listNode = listNode.next;
         }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
