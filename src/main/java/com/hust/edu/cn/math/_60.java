package com.hust.edu.cn.math;

import org.junit.Test;

public class _60 {
    @Test
    public void test() {
        System.out.print(getPermutation(9, 7));
    }

    private String getPermutation(int n, int k) {
        StringBuilder s = new StringBuilder();
        int[] nums = new int[10];
        nums[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            nums[i] = i * nums[i - 1];
        }
        boolean[] flag = new boolean[n + 1];
        int cnt = n;
        while (cnt > 0) {
            int level = (k - 1) / nums[cnt - 1] + 1;
            int j = 0, i = 0;
            while (j < level) {
                if (!flag[++i]) {
                    j++;
                }
            }
            s.append(i);
            k -= (level - 1) * nums[cnt - 1];
            flag[i] = true;
            cnt--;
        }
        return s.toString();
    }
}
