package com.hust.edu.cn.twoPointers;

import java.util.Arrays;

public class _16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            int begin = i + 1, end = nums.length - 1;
            while (begin < end) {
                int sum = nums[i] + nums[begin] + nums[end];
                if (sum == target) {
                    return sum;
                } else if (sum < target) {
                    begin++;
                    while (begin < end && nums[begin] == nums[begin - 1]) {
                        begin++;
                    }
                } else {
                    end--;
                    while (begin < end && nums[end] == nums[end + 1]) {
                        end--;
                    }
                }
                if (Math.abs(sum - target) < Math.abs(sum - res)) {
                    res = sum;
                }
            }
        }
        return res;
    }
}
