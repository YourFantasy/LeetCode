package Stack;

import org.junit.Test;

import java.util.Stack;

public class _150 {
    @Test
    public void test() {
        String[] tokens = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println(evalRPN(tokens));
    }

    public int evalRPN(String[] tokens) {
        if (tokens.length == 1)
            return Integer.parseInt(tokens[0]);
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            String s = tokens[i];
            if (stack.isEmpty() || (!s.equals("+") && !s.equals("-") && !s.equals("*") && !s.equals("/")))
                stack.push(s);
            else {
                int a = Integer.parseInt(stack.pop());
                int b = Integer.parseInt(stack.pop());
                if (s.equals("+"))
                    stack.push((a + b) + "");
                if (s.equals("-"))
                    stack.push((b - a) + "");
                if (s.equals("*"))
                    stack.push((a * b) + "");
                if (s.equals("/"))
                    stack.push((b / a) + "");
            }
        }
        return Integer.parseInt(stack.peek());
    }
}
