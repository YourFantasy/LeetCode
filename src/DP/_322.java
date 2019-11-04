package DP;

import org.junit.Test;

import java.util.Arrays;

public class _322 {
    @Test
    public void test() {
        int[] coins = {186, 419, 83, 408};
        int amount = 6249;
        System.out.println(coinChange(coins, amount));
    }

    public int coinChange(int[] coins, int amount) {
        if (coins.length == 0 || amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }
        Arrays.sort(coins);
        if (amount < coins[0]) {
            return -1;
        }
        int[] dp = new int[amount + 1];
        for (int i = 0; i < coins.length; i++) {
            if (coins[i] <= amount) {
                dp[coins[i]] = 1;
            }
        }
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                int sub = j - coins[i];
                if (dp[sub] != 0) {
                    if (dp[j] == 0) {
                        dp[j] = dp[sub] + 1;
                    } else {
                        dp[j] = Math.min(dp[j], dp[sub] + 1);
                    }
                }
            }
        }
        return dp[amount] == 0 ? -1 : dp[amount];
    }
}
