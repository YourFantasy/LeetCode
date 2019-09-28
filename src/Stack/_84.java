package Stack;

import org.junit.Test;

import java.util.Stack;

public class _84 {
    @Test
    public void test() {
        int[] heights = {2, 1, 5, 6, 2, 3};
        System.out.println(largestRectangleArea(heights));
    }

    /**
     * 设置一个栈，栈中存放元素的索引，索引所对应的元素非递减
     *如果current < heights[stack.peek()],此时将栈中元素逐个出栈，因为栈是非递减的，所以依次比较height*width，选取最大的那个，全部出栈或者栈顶元素小于等于数组当前元素，数组继续进栈，此时栈依旧是个非递减的栈
     * 重复上述过程，找到最大的面积
     * @param heights
     * @return
     */
    private int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        int current;
        for (int i = 0; i <= n; i++) {
            if (i==n) {
                current=-1;
            } else {
                current=heights[i];
            }
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
