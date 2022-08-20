// @algorithm @lc id=100305 lang=java 
// @title er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof

package ____Offer_36_____________LCOF;

class Solution {
    Node pre = null, head = null;

    // 中序遍历
    public Node treeToDoublyList(Node root) {
        if (root == null)
            return root;
        dfs(root);
        // 首尾相连
        head.left = pre;
        pre.right = head;
        return head;
    }

    void dfs(Node root) {
        if (root == null)
            return; // 递归边界: 叶子结点返回

        // 左
        dfs(root.left);
        // 中
        if (pre != null) {
            // 前指向后
            pre.right = root;// 右节点
        } else {
            head = root; // 链表头结点
        }
        // 后指向前
        root.left = pre;// 左节点
        pre = root;
        // 右
        dfs(root.right);
    }
}