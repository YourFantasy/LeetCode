package com.hust.edu.cn.binarySearch;

public class _162 {
    public int findPeakElement(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int m = i + (j - i >> 1);
            if (nums[m] > nums[m + 1]) {
                j = m;
            } else {
                i = m + 1;
            }
        }
        return i;
    }
}
