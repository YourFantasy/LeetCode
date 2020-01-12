package com.hust.edu.cn.greedy;

import java.util.Stack;

class _921 {
    public int minAddToMakeValid(String S) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            if (stack.isEmpty() || ch == '(' || (ch == ')' && stack.peek() != '(')) {
                stack.push(ch);
            } else if (ch == ')' && stack.peek() == '(') {
                stack.pop();
            }
        }
        return stack.size();
    }

}
