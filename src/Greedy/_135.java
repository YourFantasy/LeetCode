package Greedy;

import org.junit.Test;

import java.util.Arrays;

public class _135 {
    @Test
    public void test() {
        int n = 10;
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = (int) (Math.random() * 10);
            System.out.print(nums[i] + ",");
        }
        System.out.println();
        System.out.println(candy(nums));
    }

    private int candy(int[] ratings) {
        int n = ratings.length;
        if (n <= 1) {
            return n;
        }
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                dp[i] = Math.max(dp[i], dp[i - 1] + 1);
            }
        }
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                dp[i] = Math.max(dp[i], dp[i + 1] + 1);
            }
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += dp[i];
        }
        return sum;
    }
}
