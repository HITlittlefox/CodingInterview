// @algorithm @lc id=100288 lang=java 
// @title er-cha-shu-de-jing-xiang-lcof

package ____Offer_27_________LCOF;

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
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        swapChild(root);
        mirrorTree(root.left);
        mirrorTree(root.right);
        return root;
    }

    void swapChild(TreeNode root) {
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
}