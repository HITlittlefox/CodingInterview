// @algorithm @lc id=100312 lang=java 
// @title cong-shang-dao-xia-da-yin-er-cha-shu-ii-lcof

package ____Offer_32___II___________II_LCOF;

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
// @test([3,9,20,null,null,15,7])=[[3],[9,20],[15,7]]
    public List<List<Integer>> resList = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        levelOrderIteration(root);
        return resList;

    }

    public void levelOrderIteration(TreeNode node) {
        if (node == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);

        while (queue.isEmpty() != true) {
            List<Integer> itemsOfThisDepth = new ArrayList<>();
            int len = queue.size();
            while (len-- != 0) {
                TreeNode temp = queue.poll();
                itemsOfThisDepth.add(temp.val);
                if (temp.left != null) {
                    queue.offer(temp.left);
                }
                if (temp.right != null) {
                    queue.offer(temp.right);
                }
            }
            resList.add(itemsOfThisDepth);
        }
    }

}