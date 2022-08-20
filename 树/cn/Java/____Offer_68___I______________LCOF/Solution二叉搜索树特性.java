// @algorithm @lc id=100346 lang=java 
// @title er-cha-sou-suo-shu-de-zui-jin-gong-gong-zu-xian-lcof

package ____Offer_68___I______________LCOF;

import algm.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution二叉搜索树特性 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            // p,q 都在 root 的右子树中
            if (root.val < p.val && root.val < q.val)
                // 遍历至右子节点
                root = root.right;
            // p,q 都在 root 的左子树中
            else if (root.val > p.val && root.val > q.val)
                // 遍历至左子节点
                root = root.left;
            else
                // 骑着两个数了
                break;
        }
        return root;
    }
}