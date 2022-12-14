// @algorithm @lc id=100286 lang=java 
// @title he-bing-liang-ge-pai-xu-de-lian-biao-lcof

package ____Offer_25____________LCOF;

import algm.*;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
// 双指针
class Solution {
    // @test([1,2,4], [1,3,4])=[1,1,2,3,4,4]
// @test([1,2,4], [1,3,4])=[1,1,2,3,4,4]
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        // 两个链表往后遍历,谁小加谁,并且往后走
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cur.next = new ListNode(l1.val);
                cur = cur.next;
                l1 = l1.next;
            } else if (l1.val > l2.val) {
                cur.next = new ListNode(l2.val);
                cur = cur.next;
                l2 = l2.next;
            }
        }
        // 截至目前,有一个链表已经遍历完毕,还剩一个链表
        while (l1 != null) {
            cur.next = new ListNode(l1.val);
            cur = cur.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            cur.next = new ListNode(l2.val);
            cur = cur.next;
            l2 = l2.next;
        }
        return dummy.next;
    }
}