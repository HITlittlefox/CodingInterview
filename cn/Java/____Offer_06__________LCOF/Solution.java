// @algorithm @lc id=100282 lang=java 
// @title cong-wei-dao-tou-da-yin-lian-biao-lcof

package ____Offer_06__________LCOF;

import java.util.Stack;

import algm.*;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
// 数组
public class Solution {
    public int[] reversePrint(ListNode head) {
        int count = 0;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        while (head != null) {
            count++;
            head = head.next;
        } // 得到count
        int[] res = new int[count];
        dummy = dummy.next;
        for (int i = count - 1; i >= 0; i--) {
            res[i] = dummy.val;
            dummy = dummy.next;
        }
        return res;

    }
}