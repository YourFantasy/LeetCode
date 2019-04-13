package Stack;

import org.junit.Test;

import java.util.Stack;

public class _84 {
    @Test
    public void test() {
        int[] heights = {2, 1, 5, 6, 2, 3};
        System.out.println(largestRectangleArea(heights));
    }

    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        int current;
        for (int i = 0; i <= n; i++) {
            if (i==n)
                current=-1;
            else
                current=heights[i];
            while (!stack.isEmpty() && current < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                max = Math.max(max, height * width);
            }
            stack.push(i);
        }
        return max;
    }
}
