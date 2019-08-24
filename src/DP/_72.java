package DP;

public class _72 {
    public int minDistance(String word1, String word2) {

        int len1 = word1.length();
        int len2 = word2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        /**
         * dp[i][i]表示从word1[0...i-1]到word2[0...j-1]所需的最小操作次数
         */
        /**
         * 变成空串自然操作数为i(全部删除，删除次数为原字符串长度)
         */
        for (int i = 0; i <= len1; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= len2; i++) {
            dp[0][i] = i;
        }
        /**
         * 从word1[0...i-1]转化为word2[0...j-1]有两种情况
         * ①：如果word1.charAt(i - 1) == word2.charAt(j - 1),此时无需替换，插入和删除了
         * ②：如果不等，此时面临三种选择，替换，插入，删除，从这三种选择中选择一个
         */
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                /**
                 * dp[i-1][j-1]表示替换，dp[i-1][j]表示插入，dp[i][j-1]表示删除，三者中选一个最小的.
                 */
                else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
                }
            }
        }
        return dp[len1][len2];
    }
}
