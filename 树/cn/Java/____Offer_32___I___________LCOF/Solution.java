// @algorithm @lc id=100311 lang=java 
// @title cong-shang-dao-xia-da-yin-er-cha-shu-lcof

package ____Offer_32___I___________LCOF;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
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
    // public List<List<Integer>> resList = new ArrayList<>();
    public List<Integer> resItems = new ArrayList<>();

    public int[] levelOrder(TreeNode root) {
        // BFS
        levelOrderIteration(root);

        int[] resInt = new int[resItems.size()];
        for (int i = 0; i < resItems.size(); i++) {
            resInt[i] = resItems.get(i);
        }
        return resInt;

    }

    public void levelOrderIteration(TreeNode node) {
        if (node == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);

        while (queue.isEmpty() != true) {
            // List<Integer> itemsOfThisDepth = new ArrayList<>();
            int len = queue.size();
            while (len-- != 0) {
                TreeNode temp = queue.poll();
                resItems.add(temp.val);
                // itemsOfThisDepth.add(temp.val);
                if (temp.left != null) {
                    queue.offer(temp.left);
                }
                if (temp.right != null) {
                    queue.offer(temp.right);
                }
            }
            // resList.add(itemsOfThisDepth);
        }
    }

}