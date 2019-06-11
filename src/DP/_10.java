package DP;

public class _10 {

    public boolean isMatch(String s, String p) {
        int len1 = s.length(), len2 = p.length();
        boolean[][] dp = new boolean[len1 +][len2];
        dp[0][0] = true;
        for (int i = 1; i <= len2; i++) {
            //dp[0][i] = (p.charAt(i - 1) == '*') && (dp[0][i - 1] || (i > 1 && dp[0][i - 2]));
            if (p.charAt(i - 1) == '*') {
                dp[0][i] = dp[0][i - 1] || (i > 1 && dp[0][i - 2]);

            }
        }
        for (int i = 1; i <= len1; i++)
            for (int j = 1; j <= len2; j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.')
                    dp[i][j] = dp[i - 1][j - 1];
                if (p.charAt(j - 1) == '*') {
                    if (j > 1 && p.charAt(j - 2) != s.charAt(i - 1) && p.charAt(j - 2) != '.')
                        dp[i][j] = dp[i][j - 2];
                    else
                        dp[i][j] = dp[i - 1][j] || dp[i][j - 1] || dp[i][j - 2];
                }
            }
        return dp[len1][len2];
    }
}
