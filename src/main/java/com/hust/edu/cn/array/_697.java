package com.hust.edu.cn.array;

import java.util.HashMap;
import java.util.Map;

class _697 {
    public int findShortestSubArray(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        Map<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], new int[]{1, i, i});
            } else {
                int[] temp = map.get(nums[i]);
                temp[0] += 1;
                temp[2] = i;
            }
        }
        int degree = 1, res = n;
        for (int[] value : map.values()) {
            if (value[0] >= degree) {
                degree = value[0];
                res = Math.min(res, value[2] - value[1] + 1);
            } else if (value[0] == degree) {
                res = Math.min(res, value[2] - value[1] + 1);
            }
        }
        return res;
    }
}
