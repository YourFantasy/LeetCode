package com.hust.edu.cn.string;

class _551 {
    public boolean checkRecord(String s) {
        int len = s.length();
        if (len < 2) {
            return true;
        }
        int[] dp = new int[len];
        int nums1 = 0, nums2 = 0;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == 'A') {
                nums1++;
            }
            if (nums1 > 1) {
                return false;
            }
            if (s.charAt(i) == 'L') {
                nums2++;
            } else {
                nums2 = 0;
            }
            if (nums2 > 2) {
                return false;
            }

        }
        return true;
    }
}
