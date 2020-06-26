package com.hust.edu.cn.dp;

public class _983 {
    /**
     * 典型的动态规划问题：
     * 解决问题之前先要扩展一下days，因为days是严格递增的，但非连续的，先要判断哪些days是有的
     * 当前days如果是存在的，一定是由其"前一个"day选择某种花费而得到的
     * 有三种可能性，选择三种花费的其中一种，比较三种花费，取最小值
     * 如果当前day不存在，则当前day与前一天的花费一样（因为该day的上一个存在的day的花费已经确定了，要到达该day的下一个存在的day，必须花费一定的金额，在这中间的不存在的day，不存在额外花费问题）
     *
     * @param days
     * @param costs
     * @return
     */
    public int mincostTickets(int[] days, int[] costs) {
        int maxDay = days[days.length - 1];
        int[] dp = new int[maxDay + 1];
        int[] cnt = new int[366];
        for (int day : days) {
            cnt[day]++;
        }

        for (int i = 1; i <= maxDay; i++) {
            if (cnt[i] > 0) {
                dp[i] = threeMin(dp[Math.max(0, i - 1)] + costs[0], dp[Math.max(0, i - 7)] + costs[1], dp[Math.max(0, i - 30)] + costs[2]);
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[maxDay];
    }

    private int threeMin(int first, int second, int third) {
        return Math.min(Math.min(first, second), third);
    }
}
