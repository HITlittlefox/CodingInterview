// @algorithm @lc id=100307 lang=java 
// @title xu-lie-hua-er-cha-shu-lcof

package ____Offer_37_________LCOF;

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
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        if (root == null)
            return "[]";
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        // 使用队列层序遍历
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                sb.append(node.val + ",");
                queue.add(node.left);
                queue.add(node.right);

            } else {
                sb.append("null" + ",");
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("]");
        return sb.toString();

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("[]"))
            return null; // 空字符串直接返回
        String[] str = data.substring(1, data.length() - 1).split(","); // 去掉[],用","分割
        int i = 0; // 遍历数组
        TreeNode root = new TreeNode(Integer.parseInt(str[i]));
        i++; // 跳过根结点
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        // 使用队列层序遍历
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (!"null".equals(str[i])) {
                node.left = new TreeNode(Integer.parseInt(str[i]));
                queue.add(node.left);
            }
            i++; // 更新下标
            if (!"null".equals(str[i])) {
                node.right = new TreeNode(Integer.parseInt(str[i]));
                queue.add(node.right);
            }
            i++;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));