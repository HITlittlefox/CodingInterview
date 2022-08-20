// @algorithm @lc id=100275 lang=java 
// @title shu-zu-zhong-zhong-fu-de-shu-zi-lcof

package ____Offer_03__________LCOF;

// 原地交换 ![20220812012028](https://raw.githubusercontent.com/HITlittlefox/pictures/master/images/20220812012028.png)
class Solution {
    public int findRepeatNumber(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] == i) {
                i++;
                continue;
            }
            if (nums[nums[i]] == nums[i])
                return nums[i];
            int tmp = nums[i];
            nums[i] = nums[tmp];
            nums[tmp] = tmp;
        }
        return -1;
    }
}