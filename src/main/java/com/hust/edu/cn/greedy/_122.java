package com.hust.edu.cn.greedy;

class _122 {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int min = prices[0], max = prices[0];
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] >= max) {
                max = prices[i];
            } else {
                res += max - min;
                max = prices[i];
                min = prices[i];
            }
        }
        if (max != min) {
            res += max - min;
        }
        return res;
    }
}
