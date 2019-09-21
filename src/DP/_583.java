package DP;

/**
 * @author YourFantasy
 * @date 2019/9/19 5:43 下午
 * @description: 两个字符串的删除操作，使得两个字符串相等的最少删除次数
 * 算法思想：逆向思维
 * 1、题目让求使得两个字符串相等的最小删除次数；首先明确的是，在删除的过程中，无论怎么删除，原字符串的相对顺序是不变的，并且删除之后的字符串是原字符串的子序列
 * 2、删除之后的字符串相等，说明这个相等的字符串是两个原字符串的公共子序列
 * 3、删除次数最少，说明得到的公共子序列最长；同理公共子序列最长，删除的次数肯定也是最少
 * 4、所以问题转变为求两个字符串的最长公共子序列长度
 */
public class _583 {
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return m + n - 2 * dp[m][n];
    }
}
