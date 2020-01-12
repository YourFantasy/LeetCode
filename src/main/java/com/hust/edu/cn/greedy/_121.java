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
}
