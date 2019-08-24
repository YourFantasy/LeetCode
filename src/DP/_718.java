package DP;

public class _718 {
    public int findLength(int[] A, int[] B) {
        int len1 = A.length, len2 = B.length;
        int[][] dp = new int[len1][len2];
        for (int i = 0; i < len1; i++) {
            if (A[i] == B[0]) {
                dp[i][0] = 1;
            }
        }
        for (int j = 0; j < len2; j++) {
            if (B[j] == A[0]) {
                dp[0][j] = 1;
            }
        }
        int res = 0;
        for (int i = 1; i < len1; i++) {
            for (int j = 1; j < len2; j++) {
                if (A[i] == B[j]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = 0;
                }
                res = Math.max(res, dp[i][j]);
            }
        }
        return res;

    }
}
