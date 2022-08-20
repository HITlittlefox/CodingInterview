// @algorithm @lc id=100289 lang=java 
// @title dui-cheng-de-er-cha-shu-lcof

package ____Offer_28_________LCOF;

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
    // @test([1,2,2,3,4,4,3])=true
    // @test([1,2,2,3,4,4,3])=true
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSame(root.left, root.right);

    }

    boolean isSame(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null || left.val != right.val) {
            return false;
        }
        // 外侧和内侧
        return isSame(left.left, right.right) &&
                isSame(left.right, right.left);

    }
}