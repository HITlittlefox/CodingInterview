// @algorithm @lc id=100326 lang=java 
// @title liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof

package ____Offer_52_______________LCOF;

import algm.*;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
// 当第一条链表遍历完，移动到第二条链表的头部进行遍历；
// 当第二条链表遍历完，移动到第一条链表的头部进行遍历。
// 如果存在交点：
// 第一条链表首次到达「第一个相交节点」的充要条件是第一条链表走了 a + c + b 步，
// 由于两条链表同时出发，并且步长相等，因此当第一条链表走了 a + c + b 步时，第二条链表同样也是走了 a + c + b 步，即
// 第二条同样停在「第一个相交节点」的位置。
// 如果不存在交点：
// 两者会在走完 a + c + b + c+c 之后同时变为 nullnull，退出循环。
class Solution {
    // @test(8,[4,1,8,4,5],[5,0,1,8,4,5],2,3)=Intersected at '8'
    ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode aStart = headA;
        ListNode bStart = headB;

        while (headA != headB) {
            headA = headA == null ? bStart : headA.next;
            headB = headB == null ? aStart : headB.next;

        }
        return headA;
    }
}