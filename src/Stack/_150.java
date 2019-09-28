package Stack;

import org.junit.Test;

import java.util.Stack;

public class _150 {
    @Test
    public void test() {
        String[] tokens = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println(evalRPN(tokens));
    }

    private int evalRPN(String[] tokens) {
        if (tokens.length == 1) {
            return Integer.parseInt(tokens[0]);
        }
        Stack<String> stack = new Stack<>();
        for (String s : tokens) {
            if (stack.isEmpty() || (!"+".equals(s) && !"-".equals(s) && !"*".equals(s) && !"/".equals(s))) {
                stack.push(s);
            } else {
                int a = Integer.parseInt(stack.pop());
                int b = Integer.parseInt(stack.pop());
                if ("+".equals(s)) {
                    stack.push((a + b) + "");
                }
                if ("-".equals(s)) {
                    stack.push((b - a) + "");
                }
                if ("*".equals(s)) {
                    stack.push((a * b) + "");
                }
                if ("/".equals(s)) {
                    stack.push((b / a) + "");
                }
            }
        }
        return Integer.parseInt(stack.peek());
    }
}
