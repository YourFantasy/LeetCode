package Stack;

import java.util.Stack;

public class _844 {
    public boolean backspaceCompare(String S, String T) {
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) != '#') {
                stack1.push(S.charAt(i));
            } else if (!stack1.isEmpty()) {
                stack1.pop();
            }
        }
        for (int j = 0; j < T.length(); j++) {
            if (T.charAt(j) != '#') {
                stack2.push(T.charAt(j));
            } else if (!stack2.isEmpty()) {
                stack2.pop();
            }
        }
        return stack1.equals(stack2);
    }
}
