package com.hust.edu.cn.dp;

import org.junit.Test;

public class _5 {
    @Test
    public void Test() {
        String s = "babadb";
        System.out.println(longestPalindrome(s));
    }

    /**
     * dp[i][j],判断i---j之间的字符串是否是回文串
     * 如果s.charAt(i) == s.charAt(i + l) 则i---i+l 和 i+1---i+l-1同为或者同不为回文串
     * 如果i---i+l为回文串且l+1>maxlen，则maxlen=l+1,因为i---i+l之间长度为l+1
     * @param
     * @return
     */
    private String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        int maxlen = 1, begin = 0;
        boolean[][] dp = new boolean[len + 1][len + 1];
        for (int i = 0; i < len + 1; i++) {
            dp[i][i] = true;
            if (i < len - 1 && s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                begin = i;
                maxlen = 2;
            }
        }
        for (int l = 2; l < len; l++) {
            for (int i = 0; i < len - l; i++) {
                if (s.charAt(i) == s.charAt(i + l)) {
                    dp[i][i + l] = dp[i + 1][i + l - 1];
                    if (dp[i][i + l] && l > maxlen - 1) {
                        maxlen = l + 1;
                        begin = i;
                    }
                }
            }
        }
        return s.substring(begin, begin + maxlen);
    }

}
