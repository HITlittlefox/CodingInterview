// @algorithm @lc id=100294 lang=java 
// @title lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof

package ____Offer_22_______k____LCOF;

import algm.*;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {
    // @test([1,2,3,4,5], 2)=[4,5]
    // @test([1,2,3,4,5], 2)=[4,5]
    // @test([1,2,3,4,5], 2)=[4,5]
    // @test([1,2,3,4,5], 2)=[4,5]
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode fast = head;
        while (k != 0) {
            fast = fast.next;
            k--;
        }
        ListNode slow = head;
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        // fast 指到 null
        // slow 指到 倒数第k个节点
        return slow;
    }
}