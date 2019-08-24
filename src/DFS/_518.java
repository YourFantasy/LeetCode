package DFS;

import org.junit.Test;

public class _518 {
    int cnt = 0;

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
    public int change1(int amount, int[] coins) {
        dfs(amount, coins, 0, 0);
        return cnt;
    }

    public void dfs(int amount, int[] coins, int temp, int begin) {
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
    public int change2(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j >= coins[i]) {
                    dp[j] += dp[j - coins[i]];
                }
            }
        }
        return dp[amount];
    }
}
