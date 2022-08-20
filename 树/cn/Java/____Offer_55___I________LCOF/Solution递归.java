// @algorithm @lc id=100319 lang=java 
// @title er-cha-shu-de-shen-du-lcof

package ____Offer_55___I________LCOF;

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
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        return Math.max(
                maxDepth(root.left),
                maxDepth(root.right))
                + 1;
    }
}