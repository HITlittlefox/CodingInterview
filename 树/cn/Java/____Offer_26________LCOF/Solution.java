// @algorithm @lc id=100287 lang=java 
// @title shu-de-zi-jie-gou-lcof

package ____Offer_26________LCOF;

import algm.*;

class Solution {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }
        // 先从根节点判断B是不是A的子结构，
        // 如果不是在分别从左右两个子树判断，
        // 只要有一个为true，就说明B是A的子结构
        return isSub(A, B) ||
                isSubStructure(A.left, B) ||
                isSubStructure(A.right, B);
    }

    boolean isSub(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }
        // 走到这里B!=null
        if (A == null || A.val != B.val) {
            return false;
        }
        return isSub(A.left, B.left) && isSub(A.right, B.right);
    }
}