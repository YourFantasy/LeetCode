package Stack;

import org.junit.Test;

import java.util.Stack;

public class _946 {
    @Test
    public void test() {
        int[] pushed = {1, 2, 3, 4, 5};
        int[] poped = {4, 3, 5, 1, 2};
        System.out.print(validateStackSequences(pushed, poped));
    }

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int len = pushed.length;
        if (len < 3)
            return true;
        int i = 0, j = 0;
        Stack<Integer> stack = new Stack<>();

        while (i < len) {
            stack.push(pushed[i++]);
            while (i < len && !stack.empty() && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            }

        }
        while (!stack.empty()) {
            if (stack.peek() == popped[j]) {
                stack.pop();
                j++;
            } else
                break;
        }
        return stack.empty();
    }
}
