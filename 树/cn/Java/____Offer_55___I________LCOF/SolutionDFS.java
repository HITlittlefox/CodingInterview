// @algorithm @lc id=100319 lang=java 
// @title er-cha-shu-de-shen-du-lcof

package ____Offer_55___I________LCOF;

import java.util.LinkedList;
import java.util.Queue;

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
        int result = dfs(root);
        return result;
    }

    int dfs(TreeNode root) {
        int result = 0;
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            result++;
            while (len > 0) {
                TreeNode temp = queue.poll();
                // System.out.println(temp.val);
                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
                len--;
            }
        }
        return result;
    }
}