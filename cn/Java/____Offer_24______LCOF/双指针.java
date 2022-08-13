// @algorithm @lc id=100298 lang=java 
// @title fan-zhuan-lian-biao-lcof

package ____Offer_24______LCOF;

import algm.*;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
// 迭代（双指针）
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode cur = head, pre = null;
        while (cur != null) {
            ListNode tmp = cur.next; // 暂存后继节点 cur.next
            cur.next = pre; // 修改 next 引用指向
            pre = cur; // pre 暂存 cur
            cur = tmp; // cur 访问下一节点
        }
        return pre;
    }
}