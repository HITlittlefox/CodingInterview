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
class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        if (root == null) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        // 层序遍历
        while (queue.isEmpty() == false) {
            TreeNode temp = queue.poll();
            if (temp != null) {
                sb.append(temp.val + ",");
                queue.add(temp.left);
                queue.add(temp.right);

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

        int i = 0;
        TreeNode root = new TreeNode(Integer.parseInt(str[i]));
        i++;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (queue.isEmpty() == false) {
            TreeNode node = queue.poll();
            if (str[i].equals("null") == false) {
                node.left = new TreeNode(Integer.parseInt(str[i]));
                queue.offer(node.left);
            }
            i++;
            if (str[i].equals("null") == false) {
                node.right = new TreeNode(Integer.parseInt(str[i]));
                queue.offer(node.right);
            }
            i++;
        }
        return root;
    }

}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));