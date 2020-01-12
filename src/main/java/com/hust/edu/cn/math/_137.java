package com.hust.edu.cn.math;

public class _137 {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int cnt = 0;
            int bit = 1 << i;
            for (int j = 0; j < nums.length; j++) {
                if ((nums[j] & bit) != 0) {
                    cnt++;
                }
            }
            if (cnt % 3 != 0) {
                res |= bit;
            }
        }
        return res;
    }
}
