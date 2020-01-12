package com.hust.edu.cn.hashMap;

import java.util.HashMap;
import java.util.Map;

class _219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])&&i!=map.get(nums[i])&&Math.abs(i-map.get(nums[i]))<=k) {
                return true;
            }
                map.put(nums[i], i);
        }
        return false;
    }
}
