// @algorithm @lc id=100315 lang=java 
// @title er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof

package ____Offer_33______________LCOF;

class Solution {
    public boolean verifyPostorder(int[] postorder) {
        return helper(postorder, 0, postorder.length - 1);
    }

    boolean helper(int[] postorder, int left, int right) {
        if (left > right) {
            return true;
        }
        int mid = left;
        // 根节点
        int root = postorder[right];
        while (postorder[mid] < root) {
            mid++;
        } // 从前往后,第一个大于根节点的数,就是mid
          // 看mid--right之间有没有小于root的值
        int temp = mid;
        while (temp < right) {
            if (postorder[temp] < root) {
                return false;
            }
            temp++;
        }
        return helper(postorder, left, mid - 1) &&
                helper(postorder, mid, right - 1);
    }
}