```java
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=102 lang=java
 *
 * [102] 二叉树的层序遍历
 */

// @lc code=start

// Definition for a binary tree node.

class Solution {

    public List<List<Integer>> resList = new ArrayList<List<Integer>>();

    public List<List<Integer>> levelOrder(TreeNode root) {

        // BFS
        levelOrderIteration(root);
        return resList;
    }

    // BFS--迭代方式--借助队列
    public void levelOrderIteration(TreeNode node) {
        if (node == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        // 先添加一个
        queue.add(node);

        while (!queue.isEmpty()) {
            List<Integer> deepItemList = new ArrayList<Integer>();
            int len = queue.size();
            // len=1
            while (len > 0) {
                TreeNode temp = queue.poll();
                deepItemList.add(temp.val);

                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
                len--;
            }
            resList.add(deepItemList);
        }
    }
}
// @lc code=end
```