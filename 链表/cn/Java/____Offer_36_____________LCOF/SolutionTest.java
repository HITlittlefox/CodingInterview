// @algorithm @lc id=100305 lang=java 
// @title er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof

package ____Offer_36_____________LCOF;


/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/
class Solution {
    Node pre = null;
    Node head = null;

    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return root;
        }
        dfs(root);
        head.left = pre;
        pre.right = head;
        return head;
    }

    void dfs(Node root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        if (pre != null) {
            pre.right = root;
        } else if (pre == null) {
            // 头
            head = root;
        }
        root.left = pre;
        pre = root;

        dfs(root.right);
    }
}