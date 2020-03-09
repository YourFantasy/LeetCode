package com.hust.edu.cn.greedy;

public class _121 {

    public int maxProfit(int[] prices) {

        int len = prices.length;
        if (len == 0) {
            return 0;
        }
        int min = prices[0];
        int maxPrices = 0;
        for (int price : prices) {
            if (min > price) {
                min = price;
            }
            if (maxPrices < price - min) {
                maxPrices = price - min;
            }
        }
        return maxPrices;
    }

    public int maxProfit1(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            res = Math.max(res, prices[i] - prices[i - 1]);
            prices[i] = Math.min(prices[i], prices[i - 1]);
        }
        return res;
    }
}
