package DP;

public class _516 {
    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        if (len == 0)
            return 0;
        int[][] dp = new int[len][len];
        for (int i = 0; i < len; i++)
            dp[i][i] = 1;
        for (int length = 2; length <= len; length++) {
            for (int j = 0; j <= len - length; j++) {
                if (s.charAt(j + length - 1) == s.charAt(j))
                    dp[j][j + length - 1] = dp[j + 1][j + length - 2] + 2;
                else
                    dp[j][j + length - 1] = Math.max(dp[j][j + length - 2], dp[j + 1][j + length - 1]);
            }
        }
        return dp[0][len - 1];
    }
}
