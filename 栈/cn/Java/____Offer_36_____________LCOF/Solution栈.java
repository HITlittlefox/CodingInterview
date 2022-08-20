// @algorithm @lc id=100305 lang=java 
// @title er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof

package ____Offer_36_____________LCOF;

import java.util.Deque;
import java.util.LinkedList;

// 不懂
class Solution {
    // 中序遍历非递归
    public static Node treeToDoublyList(Node root) {
        if (root == null)
            return null;
        Node head = null, lastVisit = null;
        Deque<Node> stack = new LinkedList<Node>();
        Node node = root;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left; // 向左走，直到左子节点为空
            } // 其实就是找到最左的节点，然后访问
            node = stack.pop(); // 弹出访问
            if (lastVisit != null) {
                lastVisit.right = node;
            } else {
                head = node; // 第一个最左的节点为头节点，即最小值
            }
            node.left = lastVisit;
            lastVisit = node;
            node = node.right; // 处理右子树，
                               // 通过上面的while循环可以找到右子树最左的节点
        }
        head.left = lastVisit;
        lastVisit.right = head;
        return head;
    }
}