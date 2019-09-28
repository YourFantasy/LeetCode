package DP;

class _309 {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len == 0) {
            return 0;
        }
        //三种状态对应的最大利润
        int[] n = new int[len];//该天没股票
        int[] s = new int[len];//该天有股票，已经卖出，此时没股票
        int[] m = new int[len];//该天有股票，不卖
        n[0] = 0;//第一天不赚不赔
        s[0] = -1;//赔钱
        m[0] = -prices[0];//花费price[0]买股票
        for (int i = 1; i < len; i++) {
            n[i] = Math.max(n[i - 1], s[i - 1]);//不买或者在昨天卖出之间做选择
            s[i] = m[i - 1] + prices[i];//将昨天股票卖出的收益,因为此时无法买股票(昨天已经卖了股票)，此时只能选择不买或者卖出昨天的股票
            m[i] = Math.max(m[i - 1], n[i - 1] - prices[i]);//在继续持有(继续持有昨天的持有的股票)和买入之间做选择(昨天没股票)
        }
        return Math.max(n[len - 1], s[len - 1]);
    }

    public int maxProfit2(int[] prices) {
        int len = prices.length;
        if (len == 0) {
            return 0;
        }
        int n = 0;
        int s = -1;
        int m = -prices[0];
        for (int i = 1; i < len; i++) {
            int ntemp = Math.max(n, s);
            int stemp = m + prices[i];
            int mtemp = Math.max(m, n - prices[i]);
            n = ntemp;
            s = stemp;
            m = mtemp;
        }
        return Math.max(n, s);
    }
}
