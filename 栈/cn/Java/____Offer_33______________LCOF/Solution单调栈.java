// @algorithm @lc id=100315 lang=java 
// @title er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof

package ____Offer_33______________LCOF;

import java.util.Stack;

// 后续遍历结果,倒序后:
// 挨着的两个数如果arr[i]<arr[i+1]，那么arr[i+1]一定是arr[i]的右子节点
class Solution {
    public boolean verifyPostorder(int[] postorder) {
        Stack<Integer> stack = new Stack<>();
        int parent = Integer.MAX_VALUE;
        // 注意for循环是倒叙遍历的
        for (int i = postorder.length - 1; i >= 0; i--) {
            int cur = postorder[i];
            // 如果当前节点小于栈顶元素，说明栈顶元素和当前值构成了倒叙，
            // 说明当前节点是前面某个节点的左子节点，我们要找到他的父节点
            while (!stack.isEmpty() && stack.peek() > cur) {
                parent = stack.pop();
            }
            // 只要遇到了某一个左子节点，才会执行上面的代码，才会更
            // 新parent的值，否则parent就是一个非常大的值，也就
            // 是说如果一直没有遇到左子节点，那么右子节点可以非常大
            // 二叉搜索树应该是左子节点小于根节点，右子节点大于根节点
            // 这个右子节点是这个祖先节点的一个左子树的一部分，所以不能超过他
            // tql..自己举个例子捋一下：假设后序遍历倒序是[10,12,13,11,15]，11是12的左节点，15是11右节点，不能比12大

            if (cur > parent) {
                return false;
            }
            // 入栈
            stack.add(cur);
        }
        return true;
    }
}