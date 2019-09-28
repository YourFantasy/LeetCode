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
}
