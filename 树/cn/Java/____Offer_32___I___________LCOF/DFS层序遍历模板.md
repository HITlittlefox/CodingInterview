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

        // DFS
        dfs(root, 0);
        return resList;
    }

    // DFS--递归方式
    void dfs(TreeNode node, Integer deep) {
        if (node == null) {
            return;
        }
        // 层 deep=1
        deep++;
        // 如果二维列表数＜深度,为二维列表开辟新空间
        if (resList.size() < deep) {
            // 当层级增加时，list的Item也增加，利用list的索引值进行层级界定
            List<Integer> deepItem = new ArrayList<Integer>();
            resList.add(deepItem);
        }

        // [[3],
        // resList的0空间,添加第1层的数,也就是node.val
        // 为二维列表的一维列表添加值
        resList.get(deep - 1).add(node.val);

        dfs(node.left, deep);// [[3],[9,
        dfs(node.right, deep);// [[3],[9,20],
    }

}
// @lc code=end
```