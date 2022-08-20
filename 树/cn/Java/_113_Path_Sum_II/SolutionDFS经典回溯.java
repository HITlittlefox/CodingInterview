// @algorithm @lc id=113 lang=java 
// @title path-sum-ii

package _113_Path_Sum_II;

import algm.*;
import java.util.*;

// @test([5,4,8,11,null,13,4,7,2,null,null,5,1],22)=[[5,4,11,2],[5,8,4,5]]
// @test([1,2,3],5)=[]
// @test([1,2],0)=[]
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
// 解法2
class Solution {
    List<List<Integer>> result = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root, targetSum);
        return result;
    }

    private void dfs(TreeNode root, int count) {
        if (root == null)
            return;
        path.offer(root.val);
        count -= root.val;
        // 中
        if (root.left == null && root.right == null && count == 0) {
            result.add(new LinkedList<>(path));
        }
        // 左
        dfs(root.left, count);
        // 右
        dfs(root.right, count);
        path.removeLast(); // 回溯
    }
}