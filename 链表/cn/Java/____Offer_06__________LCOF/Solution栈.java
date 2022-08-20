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
// 栈
class Solution {
    public int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
        int[] res = new int[stack.size()];
        int i = 0;
        while (stack.isEmpty() == false) {
            res[i++] = stack.pop();
        }
        return res;

    }
}