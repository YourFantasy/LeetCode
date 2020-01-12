package com.hust.edu.cn.greedy;

import java.util.Arrays;

class _455 {
    public int findContentChildren(int[] g, int[] s) {
        int cnt = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int index = 0;
        for (int value : g) {
            for (int j = index; j < s.length; j++) {
                if (value <= s[j]) {
                    cnt++;
                    index = j + 1;
                    break;
                }
            }
        }
        return cnt;
    }
}
