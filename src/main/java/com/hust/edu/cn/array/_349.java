package com.hust.edu.cn.array;

import java.util.Arrays;
import java.util.HashMap;

class _349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[] result = new int[Math.min(len1, len2)];
        int k = 0;
        for (int i = 0; i < len1; i++) {
            if (!map.containsKey(nums1[i])) {
                map.put(nums1[i], i);
            }
        }
        for (int i : nums2) {
            if (map.containsKey(i)) {
                map.remove(i);
                result[k++] = i;
            }
        }
        return Arrays.copyOfRange(result, 0, k);
    }
}
