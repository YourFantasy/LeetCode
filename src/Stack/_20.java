package Stack;

import org.junit.Test;

import java.util.Stack;

public class _20 {
    @Test
    public void test() {
        String s = "]";
        System.out.println(isValid(s));
    }

    private boolean isValid(String s) {
            boolean flag = true;
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if (ch == '(' || ch == '{' || ch == '[') {
                    stack.push(s.charAt(i));
                } else {
                    if ((!stack.empty()) && is_Pair(stack.peek(), ch)) {
                        stack.pop();
                    } else {
                        flag = false;
                        return flag;
                    }

                }
            }
            if (!stack.empty()) {
                flag = false;
            }
            return flag;
    }

    private boolean is_Pair(char ch1, char ch2) {
        return ch1 == '(' && ch2 == ')' || ch1 == '{' && ch2 == '}' || ch1 == '[' && ch2 == ']';
    }
}
