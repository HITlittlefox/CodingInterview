// @algorithm @lc id=100301 lang=java 
// @title zui-xiao-de-kge-shu-lcof

package ____Offer_40____k____LCOF;

import java.util.Arrays;

class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k >= arr.length)
            return arr;
        return quickSort(arr, 0, arr.length - 1, k);
    }

    private int[] quickSort(int[] arr, int left, int right, int k) {
        int i = left, j = right;
        while (i < j) {
            while (i < j && arr[j] >= arr[left])
                j--;
            while (i < j && arr[i] <= arr[left])
                // 因为是等于号所以第一个值会留下
                i++;
            swap(arr, i, j);
        }
        swap(arr, i, left);
        if (i > k)
            return quickSort(arr, left, i - 1, k);
        if (i < k)
            return quickSort(arr, i + 1, right, k);
        return Arrays.copyOf(arr, k);
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}