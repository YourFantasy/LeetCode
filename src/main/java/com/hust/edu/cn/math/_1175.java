package com.hust.edu.cn.math;

public class _1175 {
    /**
     * 数学题：排列组合
     *
     * @param n
     * @return
     */
    public int numPrimeArrangements(int n) {
        int cnt = getPrimeCount(n);
        int min = Math.min(cnt, n - cnt);
        long minFac = getFac(1, min);
        long maxFac = getFac(min + 1, n - min);
        return (int) (minFac * minFac % 1000000007 * maxFac % 1000000007);

    }

    public long getFac(int begin, int end) {
        long res = 1;
        for (int i = begin; i <= end; i++) {
            res = (res * i) % 1000000007;
        }
        return res;
    }

    public int getPrimeCount(int n) {
        int res = 0;
        for (int i = 2; i <= n; i++) {
            boolean flag = true;
            for (int j = 2; j * j <= i; j++) {
                if (i % j == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                res++;
            }
        }
        return res;
    }

    public int cutRope(int target) {
        if (target == 2) {
            return 1;
        }
        if (target == 3) {
            return 2;
        }
        if (target == 4) {
            return 4;
        }
        int[] dp = new int[target + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        dp[4] = 4;
        for (int i = 5; i <= target; i++) {
            dp[i] = Math.max(dp[i - 2] * 3, Math.max(dp[i - 3] * 4, dp[i - 4] * 4));
        }
        return dp[target];
    }
}
