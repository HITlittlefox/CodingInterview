// @algorithm @lc id=100299 lang=java 
// @title shan-chu-lian-biao-de-jie-dian-lcof

package ____Offer_18_________LCOF;

import algm.*;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteNode(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        if (head.val == val) {
            return head.next;
        }
        while (head.next.val != val && head.next != null) {
            head = head.next;
        }
        head.next = head.next.next;
        return dummy.next;
    }
}