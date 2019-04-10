package DP;

import org.junit.Test;

public class _123 {
    @Test
    public void test() {
        int n = 10;
        int[] prices = new int[n];
        for (int i = 0; i < n; i++) {
            prices[i] = (int) (Math.random() * 15);
            System.out.print(prices[i] + " ");
        }
        System.out.println();
        System.out.println(maxProfit1(prices));
        System.out.println(maxProfit2(prices));
    }

    public int maxProfit1(int[] prices) {
        int b1 = Integer.MIN_VALUE, s1 = 0, b2 = Integer.MIN_VALUE, s2 = 0;
        for (int i = 0; i < prices.length; i++) {
            b1 = Math.max(b1, -prices[i]);
            s1 = Math.max(s1, prices[i] + b1);
            b2 = Math.max(b2, s1 - prices[i]);
            s2 = Math.max(s2, prices[i] + b2);
            System.out.println("b1:" + b1 + ",s1:" + s1 + ",b2:" + b2 + ",s2:" + s2);
        }
        return s2;
    }

    public int maxProfit2(int[] prices) {
        int b1 = Integer.MAX_VALUE, s1 = 0, b2 = Integer.MAX_VALUE, s2 = 0;
        for (int i = 0; i < prices.length; i++) {
            b1 = Math.min(b1, prices[i]);//第一次买花费的钱，越小说明花费的钱越少，b1恒为非正数
            s1 = Math.max(s1, prices[i] - b1);//在该天第一次卖出能够赚的钱
            b2 = Math.min(b2, prices[i] - s1);//将第一次赚的钱减去买股票花的钱,为第二次买股票花费的钱，越小，花费钱越少
            s2 = Math.max(s2, prices[i] - b2);//因为第一次买卖股票赚的钱用于第二次买股票了，所以第二次买卖股票赚的钱为最后能够赚的钱
            System.out.println("b1:" + b1 + ",s1:" + s1 + ",b2:" + b2 + ",s2:" + s2);

        }
        return s2;
    }
}
