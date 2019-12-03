package Stack;

import java.util.Stack;

class _32 {
    public int longestValidParentheses(String s) {
        int cnt = 0;
        int begin = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                if (stack.isEmpty()) {
                    begin = i + 1;
                } else {
                    stack.pop();
                    if (stack.isEmpty()) {
                        cnt = Math.max(cnt, i - begin + 1);
                    } else {
                        cnt = Math.max(cnt, i - stack.peek());
                    }
                }
            }

        }
        return cnt;
    }

    public int longestValidParentheses1(String s) {
        int[] dp = new int[s.length()];
        int res = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                int pre = i - 1 - dp[i - 1];
                if (pre >= 0 && s.charAt(pre) == '(') {
                    dp[i] = dp[i - 1] + 2;
                    if (pre > 0) {
                        dp[i] += dp[pre - 1];
                    }
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
