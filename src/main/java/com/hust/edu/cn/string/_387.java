package com.hust.edu.cn.string;

import java.util.Arrays;

class _387 {
    public int firstUniqChar(String s) {
        int[] nums = new int[26];
        Arrays.fill(nums, -1);
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            if (nums[index] != -1 && nums[index] != -2) {
                nums[index] = -2;
            } else if (nums[index] == -1) {
                nums[index] = i;
            }
        }
        int res = s.length();
        for (int num : nums) {
            if (num != -1 && num != -2 && res > num) {
                res = num;
            }
        }
        if (res == s.length()) {
            return -1;
        }
        return res;
    }
}
