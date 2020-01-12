package com.hust.edu.cn.array;

public class _27 {

    public int removeElement(int[] nums, int val) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[index++] = nums[i];
            }
        }
        return index;
    }

    public int removeElement1(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int begin = 0, end = nums.length - 1;
        while (begin <= end) {
            if (nums[begin] == val) {
                int temp = nums[begin];
                nums[begin] = nums[end];
                nums[end] = temp;
                end--;
            } else {
                begin++;
            }
        }
        return begin;
    }
}
