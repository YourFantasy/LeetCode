package com.hust.edu.cn.dp;

class _647 {
    public int countSubstrings(String s) {
        int length = s.length();
        if (length == 0) {
            return 0;
        }
        int cnt = 0;
        boolean[][] dp = new boolean[length][length];
        for (int i = 0; i < length; i++) {
            dp[i][i] = true;
            cnt++;

        }
        for (int j = 1; j < length; j++) {
            dp[j - 1][j] = s.charAt(j - 1) == s.charAt(j);
            if (dp[j - 1][j]) {
                cnt++;
            }
        }

        for (int len = 3; len <= s.length(); len++) {
            for (int i = 0; i <= s.length() - len; i++) {
                dp[i][i + len - 1] = dp[i + 1][i + len - 2] && s.charAt(i) == s.charAt(i + len - 1);
                if (dp[i][i + len - 1]) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
