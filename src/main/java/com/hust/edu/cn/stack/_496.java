package com.hust.edu.cn.stack;

import java.util.HashMap;

class _496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int k = 0; k < nums2.length; k++) {
            map.put(nums2[k], k);
        }
        for (int i = 0; i < nums1.length; i++) {
            boolean flag = false;
            int index = map.get(nums1[i]);
            for (int j = index; j < nums2.length; j++) {
                if (nums2[j] > nums1[i]) {
                    result[i] = nums2[j];
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                result[i] = -1;
            }

        }
        return result;
    }
}
