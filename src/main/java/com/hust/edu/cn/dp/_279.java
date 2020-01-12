package com.hust.edu.cn.dp;

import org.junit.Test;

public class _279 {
    @Test
    public void Test() {
        System.out.println(numSquares(35));
    }

    private int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            if (isSquares(i)) {
                dp[i] = 1;
            } else {
                int c = search(i);
                System.out.print(c+",");
                dp[i] = dp[i - c] + dp[c];
            }
        }
        for (int i = 1; i <= n; i++) {
            System.out.print(dp[i] + " ");
        }
        System.out.println();
        return dp[n];
    }

    private boolean isSquares(int n) {
        for (int i = 0; i <= n; i++) {
            if (n == i * i) {
                return true;
            }

        }
        return false;
    }

    private int search(int n) {
        int k = 0;
        int i = 0;
        while (k <= n) {
            i++;
            k = i * i;
        }
        return (i - 1) * (i - 1);
    }
}
