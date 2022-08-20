// @algorithm @lc id=100342 lang=java 
// @title ping-heng-er-cha-shu-lcof

package ____Offer_55___II_______LCOF;

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
class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        // 分别计算左子树和右子树的高度
        // 这两个子树的高度不能超过1
        return Math.abs(
                depth(root.left) - depth(root.right)) <= 1
                && isBalanced(root.left)
                && isBalanced(root.right);

    }

    // 计算树中节点的高度
    public int depth(TreeNode root) {
        if (root == null)
            return 0;
        return Math.max(
                depth(root.left),
                depth(root.right))
                + 1;
    }
}