package com.hust.edu.cn.stack;

import org.junit.Test;

import java.util.Stack;

public class _20 {
    @Test
    public void test() {
        String s = "]";
        System.out.println(isValid(s));
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (stack.isEmpty() && !isLeft(ch)) {
                return false;
            } else if (isLeft(ch)) {
                stack.push(ch);
            } else {
                if (!is_Pair(stack.peek(), ch)) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }

    public boolean is_Pair(char ch1, char ch2) {
        return ch1 == '(' && ch2 == ')' || ch1 == '{' && ch2 == '}' || ch1 == '[' && ch2 == ']';
    }

    public boolean isLeft(char ch) {
        return ch == '(' || ch == '{' || ch == '[';
    }
}
