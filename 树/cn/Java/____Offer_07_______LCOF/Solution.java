// @algorithm @lc id=100283 lang=java 
// @title zhong-jian-er-cha-shu-lcof

package ____Offer_07_______LCOF;

import java.util.HashMap;
import java.util.Map;

import algm.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
// 代码随想录
// https://www.programmercarl.com/0106.%E4%BB%8E%E4%B8%AD%E5%BA%8F%E4%B8%8E%E5%90%8E%E5%BA%8F%E9%81%8D%E5%8E%86%E5%BA%8F%E5%88%97%E6%9E%84%E9%80%A0%E4%BA%8C%E5%8F%89%E6%A0%91.html#java
class Solution {
    Map<Integer, Integer> map;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) { // 用map保存中序序列的数值对应位置
            map.put(inorder[i], i);
        }

        return findNode(
                preorder, 0, preorder.length,
                inorder, 0, inorder.length); // 前闭后开
    }

    public TreeNode findNode(
            int[] preorder, int preBegin, int preEnd,
            int[] inorder, int inBegin, int inEnd) {
        // 参数里的范围都是前闭后开

        // 不满足左闭右开，说明没有元素，返回空树
        if (preBegin >= preEnd || inBegin >= inEnd) {
            return null;
        }
        // 找到前序遍历的第一个元素在中序遍历中的位置
        int rootIndex = map.get(preorder[preBegin]);
        // 构造结点
        TreeNode root = new TreeNode(inorder[rootIndex]);
        // 保存中序左子树个数，用来确定前序数列的个数
        int lenOfLeft = rootIndex - inBegin;
        root.left = findNode(
                preorder, preBegin + 1, preBegin + lenOfLeft + 1,
                inorder, inBegin, rootIndex);
        root.right = findNode(
                preorder, preBegin + lenOfLeft + 1, preEnd,
                inorder, rootIndex + 1, inEnd);

        return root;
    }
}