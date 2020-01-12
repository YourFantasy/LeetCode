package com.hust.edu.cn.binarySearch;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class _350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        int[] res = new int[Math.min(nums1.length, nums2.length)];
        Map<Integer, Integer> map = new HashMap<>();
        for (int value : nums1) {
            if (!map.containsKey(value)) {
                map.put(value, 1);
            } else {
                map.put(value, map.get(value) + 1);
            }
        }
        int index = 0;
        for (int i : nums2) {
            if (map.containsKey(i) && map.get(i) != 0) {
                res[index++] = i;
                map.put(i, map.get(i) - 1);
            }
        }
        return Arrays.copyOfRange(res, 0, index);
    }

    public int[] intersect2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);

        Arrays.sort(nums2);
        int i = 0, j = 0;
        int cnt = 0;
        while (i < nums1.length && j < nums2.length) {
            while (i < nums1.length && j < nums2.length && nums1[i] == nums2[j]) {
                nums1[cnt++] = nums1[i];
                i++;
                j++;
            }
            while (i < nums1.length && j < nums2.length && nums1[i] < nums2[j]) {
                i++;
            }
            while (i < nums1.length && j < nums2.length && nums1[i] > nums2[j]) {
                j++;
            }
        }
        return Arrays.copyOfRange(nums1, 0, cnt);
    }
}
