package DP;

import org.junit.Test;

public class _91 {
    @Test
    public void test() {
        System.out.println(numDecodings("227"));
    }

    public int numDecodings(String s) {
        if (s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 1; i <s.length(); i++) {
            int ch = s.charAt(i) - '0';
            int prech = s.charAt(i - 1) - '0';
            if (prech == 0 && ch == 0 || (ch == 0 && (prech * 10 + ch > 26))) {
                return 0;
            } else if (prech == 0 || (prech * 10 + ch) > 26) {
                dp[i + 1] = dp[i];
            } else if (ch == 0) {
                dp[i + 1] = dp[i - 1];
            } else {
                dp[i + 1] = dp[i] + dp[i - 1];
            }
        }

        return dp[dp.length - 1];
    }
}
