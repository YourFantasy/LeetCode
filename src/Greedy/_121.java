package Greedy;

import org.junit.Test;

public class _121 {
    @Test
    public void Test() {

    }

    public int maxProfit(int[] prices) {

        int len = prices.length;
        if (len == 0) {
            return 0;
        }
        int min = prices[0];
        int maxPrices = 0;
        for (int i = 0; i < len; i++) {
            if (min > prices[i]) {
                min = prices[i];
            }
            if (maxPrices < prices[i] - min) {
                maxPrices = prices[i] - min;
            }
        }
        return maxPrices;
    }
}
