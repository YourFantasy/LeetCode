package DP;

import org.junit.Test;

public class _413 {
    @Test
    public void Test() {
        int n = 20;
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = (int) (2 * Math.random() * n);
        }
        for (int i = 0; i < n; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
        System.out.println(numberOfArithmeticSlices(nums));
    }

    private int numberOfArithmeticSlices(int[] A) {
        if (A.length < 3) {
            return 0;
        }
        int[] dp = new int[A.length];
        int d = A[1] - A[0];
        int len = 2;
        for (int i = 2; i < A.length; i++) {
            if (A[i] - A[i - 1] == d) {
                dp[i] = dp[i - 1] + len - 1;
                len++;
            } else {
                dp[i] = dp[i - 1];
                d = A[i] - A[i - 1];
                len = 2;
            }
        }
        return dp[A.length - 1];
    }
}
