// @algorithm @lc id=100305 lang=java 
// @title er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof

package ____Offer_36_____________LCOF;

import java.util.ArrayList;

class Solution {
    public ArrayList<Node> list = new ArrayList<>();

    public Node treeToDoublyList(Node root) {
        if (root == null)
            return null;
        dfs(root);// 中序遍历得到数组

        int n = list.size();
        Node pre = list.get(n - 1);
        for (int i = 0; i < n - 1; i++) {
            Node cur = list.get(i);
            cur.left = pre;
            cur.right = list.get(i + 1);// 最后一个是n-1,没有越界
            pre = cur;
        } // 此时pre在倒数第二个
          // 首尾连接
        Node cur = list.get(n - 1);
        cur.left = pre;
        cur.right = list.get(0);
        return list.get(0);
    }

    public void dfs(Node root) {
        if (root != null) {
            dfs(root.left);
            list.add(root);
            dfs(root.right);
        }
    }
}