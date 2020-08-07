package com.hust.edu.cn.stack;

import java.util.Stack;

class _503 {
    public int[] nextGreaterElements1(int[] nums) {
        int len = nums.length;
        int[] result = new int[len];
        for (int i = 0; i < len; i++) {
            boolean flag = false;
            for (int j = 1; j < len; j++) {
                int temp = (i + j) % len;
                if (nums[temp] > nums[i]) {
                    result[i] = nums[temp];
                    flag = true;
                    break;
                }

            }
            if (!flag) {
                result[i] = -1;
            }
        }
        return result;
    }

    /**
     * 单调栈，如果栈不为空并且当前元素大于栈顶元素，说明当前元素是栈顶元素的下一个 比它大的元素
     * 如果栈不为空，说明栈里这些元素向后找不到比他大的元素，只能向他们的前半部分找。
     *
     * @param nums
     * @return
     */
    public int[] nextGreaterElements2(int[] nums) {
        int[] res = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                int index = stack.pop();
                res[index] = nums[i];
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int index = stack.pop();
            boolean flag = false;
            // 从0——index-1 找，因为是循环的数组
            for (int i = 0; i < index; i++) {
                // 找到直接返回，不必继续遍历
                if (nums[i] > nums[index]) {
                    res[index] = nums[i];
                    flag = true;
                    break;
                }
            }
            // 没找到说明不存在，设置为-1
            if (!flag) {
                res[index] = -1;
            }
        }
        return res;
    }
}
