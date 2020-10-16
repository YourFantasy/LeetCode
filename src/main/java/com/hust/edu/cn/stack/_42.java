package com.hust.edu.cn.stack;

import java.util.Stack;

public class _42 {
    public int trap1(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int res = 0;
        for (int i = 1; i < height.length; i++) {
            int max1 = 0, max2 = 0;
            for (int j = 0; j <= i; j++) {
                max1 = Math.max(max1, height[j]);
            }
            for (int j = i; j < height.length; j++) {
                max2 = Math.max(max2, height[j]);
            }
            res += Math.min(max1, max2) - height[i];
        }
        return res;
    }

    public int trap2(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int i = 0, j = height.length - 1, max1 = 0, max2 = 0, index1 = 0, index2 = 0, res = 0;
        while (i <= j) {
            if (max1 < max2) {
                max1 = Math.max(max1, height[i]);
                res += max1 - height[i];
                i++;
            } else {
                max2 = Math.max(max2, height[j]);
                res += max2 - height[j];
                j--;
            }
        }
        return res;

    }

    public int trap3(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                int index = stack.pop();
                while (!stack.isEmpty() && height[stack.peek()] == height[index]) {
                    stack.pop();
                }
                if (!stack.isEmpty()) {
                    int w = i - stack.peek() - 1;
                    int h = Math.min(height[i], height[stack.peek()]) - height[index];
                    res += w * h;
                }
            }
            stack.push(i);
        }
        return res;
    }
}
