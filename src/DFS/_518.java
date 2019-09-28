package DFS;

import org.junit.Test;

public class _518 {
    private int cnt = 0;

    @Test
    public void test() {
        int[] coins = {3, 5, 7, 8, 9, 10, 11};
        int amount = 500;
        System.out.println(change1(amount, coins));
        System.out.println(change2(amount, coins));
    }

    /**
     * 暴力深搜，超时。
     *
     * @param amount
     * @param coins
     * @return
     */
    private int change1(int amount, int[] coins) {
        dfs(amount, coins, 0, 0);
        return cnt;
    }

    private void dfs(int amount, int[] coins, int temp, int begin) {
        if (temp > amount || begin >= coins.length) {
            return;
        }
        if (temp == amount) {
            cnt++;
            return;
        }
        for (int i = begin; i < coins.length; i++) {
            dfs(amount, coins, temp + coins[i], i);
        }
    }

    /**
     * 动态规划
     *
     * @param amount
     * @param coins
     * @return
     */
    private int change2(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int j = 1; j <= amount; j++) {
                if (j >= coin) {
                    dp[j] += dp[j - coin];
                }
            }
        }
        return dp[amount];
    }
}
