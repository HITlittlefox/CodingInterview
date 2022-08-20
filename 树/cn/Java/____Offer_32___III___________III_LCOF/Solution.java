// @algorithm @lc id=100314 lang=java 
// @title cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof

package ____Offer_32___III___________III_LCOF;

import java.util.*;

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
    // @test([3,9,20,null,null,15,7])=[[3],[20,9],[15,7]]
    public List<List<Integer>> resList = new ArrayList<>();
    public List<List<Integer>> realresList = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        levelOrderIteration(root);
        // 对0 2 4 6 进行逆序
        for (int i = 0; i < resList.size(); i++) {
            if (i % 2 == 0) {
                realresList.add(resList.get(i));
                continue;
            }
            if (i % 2 != 0) {
                Stack<Integer> stack = new Stack<>();
                for (Integer integer : resList.get(i)) {
                    stack.add(integer);
                }
                List<Integer> reversedList = new ArrayList<>();
                while (stack.isEmpty() != true) {
                    reversedList.add(stack.pop());
                }
                realresList.add(reversedList);
                continue;
            }
        }
        return realresList;
    }

    public void levelOrderIteration(TreeNode node) {
        if (node == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        while (queue.isEmpty() != true) {
            List<Integer> itemsOfThisDepth = new ArrayList<>();
            int len = queue.size();
            while (len-- > 0) {
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