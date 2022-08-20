// @algorithm @lc id=100317 lang=java 
// @title er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof

package ____Offer_34______________LCOF;

import algm.*;
import java.util.*;

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
    List<List<Integer>> ans = new ArrayList<>();
    int t;

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        t = target;
        dfs(root, 0, new ArrayList<>());
        return ans;
    }

    void dfs(TreeNode root, int cur, List<Integer> list) {
        // 中
        if (root == null)
            return;
        list.add(root.val);
        if (cur + root.val == t && root.left == null && root.right == null)
            ans.add(new ArrayList<>(list));
        // 左
        dfs(root.left, cur + root.val, list);
        // 右
        dfs(root.right, cur + root.val, list);
        list.remove(list.size() - 1);
    }
}