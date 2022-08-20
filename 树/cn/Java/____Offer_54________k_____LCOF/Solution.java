// @algorithm @lc id=100333 lang=java 
// @title er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof

package ____Offer_54________k_____LCOF;

import java.util.ArrayList;

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
    // @test([3,1,4,null,2], 1)=4
    // @test([3,1,4,null,2], 1)=4
    ArrayList<Integer> list = new ArrayList<>();

    public int kthLargest(TreeNode root, int k) {
        inOrder(root);
        return list.get(list.size() - k);
    }

    void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        list.add(root.val);
        inOrder(root.right);
        return;
    }
}