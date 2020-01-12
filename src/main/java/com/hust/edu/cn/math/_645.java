package com.hust.edu.cn.math;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class _645 {
    public int[] findErrorNums(int[] nums) {
        int[] result = new int[2];
        Set<Integer> set = new HashSet<>();
        int i = 0;
        while (set.add(nums[i])) {
            i++;
        }
        result[0] = nums[i];
        Map<Integer, Integer> map = new HashMap<>();
        for (int j = 0; j < nums.length; j++) {
            map.put(nums[j], j);
        }
        for (int k = 1; k <= nums.length; k++) {
            if (!map.containsKey(k)) {
                result[1] = k;
                break;
            }
        }
        return result;
    }
}
