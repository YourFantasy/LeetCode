package com.hust.edu.cn.hashMap;

import java.util.HashMap;
import java.util.Map;

public class _128 {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                int left = map.getOrDefault(nums[i] - 1, 0);
                int right = map.getOrDefault(nums[i] + 1, 0);
                res = Math.max(res, left + right + 1);
                // 左右都为空，都靠不住，靠自己，当前位置为起点的最大长度为left + right + 1
                if (left == 0 && right == 0) {
                    map.put(nums[i], 1);
                }
                // 都不为空，nums[i]可以退休
                if (left != 0 && right != 0) {
                    map.put(nums[i], 0);
                }
                // 左右有一个为空，当前位置为起点的最大长度为left + right + 1
                if (left == 0 || right == 0) {
                    map.put(nums[i], left + right + 1);
                }
                // nums[i]-left 为起点的最大长度为left + right + 1
                if (left != 0) {
                    map.put(nums[i] - left, left + right + 1);
                }
                // (nums[i] + right 为起点的最大长度为left + right + 1
                if (right != 0) {
                    map.put(nums[i] + right, left + right + 1);
                }
            }
        }
        return res;
    }
}
