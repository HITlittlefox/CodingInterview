// @algorithm @lc id=112 lang=java 
// @title path-sum

package _112_Path_Sum;

import algm.*;

// @test([5,4,8,11,null,13,4,7,2,null,null,null,1],22)=true
// @test([1,2,3],5)=false
// @test([],0)=false
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public boolean hasPathSum(TreeNode root, int targetsum) {
        if (root == null) {
            return false;
        }
        targetsum -= root.val;
        // 叶子结点
        if (root.left == null && root.right == null) {
            return targetsum == 0 ? true : false;
        }
        // 左
        if (root.left != null) {
            boolean left = hasPathSum(root.left, targetsum);
            if (left) {// 已经找到
                return true;
            }
        }
        // 右
        if (root.right != null) {
            boolean right = hasPathSum(root.right, targetsum);
            if (right) {// 已经找到
                return true;
            }
        }
        return false;
    }
}
