// @algorithm @lc id=100275 lang=java 
// @title shu-zu-zhong-zhong-fu-de-shu-zi-lcof

package ____Offer_03__________LCOF;

import java.util.HashSet;
import java.util.Set;

// 哈希表/Set/ ArrayList
public class Solution {
    public int findRepeatNumber(int[] nums) {
        Set<Integer> dic = new HashSet<>();
        for (int num : nums) {
            if (dic.contains(num))
                return num;
            dic.add(num);
        }
        return -1;
    }
}