package com.hust.edu.cn.array;

import java.util.Arrays;

public class _1051 {
    public int heightChecker(int[] heights) {
        int[] temp = new int[heights.length];
        for (int i = 0; i < heights.length; i++) {
            temp[i] = heights[i];
        }
        Arrays.sort(temp);
        int cnt = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != temp[i]) {
                cnt++;
            }
        }
        return cnt;
    }
}
