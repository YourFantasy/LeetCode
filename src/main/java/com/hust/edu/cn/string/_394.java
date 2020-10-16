package com.hust.edu.cn.string;

import java.util.Stack;

public class _394 {
    public String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == ']') {
                String sb = "";
                while (!stack.isEmpty() && !stack.peek().equals("[")) {
                    sb = stack.pop() + sb;
                }
                stack.pop();
                String cnt = "";
                while (!stack.isEmpty() && isDigit(stack.peek().charAt(0))) {
                    cnt = stack.pop() + cnt;
                }
                int count = Integer.parseInt(cnt);
                String temp = sb;
                for (int j = 1; j < count; j++) {
                    sb += temp;
                }
                stack.push(sb);
            } else {
                stack.push(ch + "");
            }
        }
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            res.insert(0, stack.pop());
        }
        return res.toString();
    }

    private boolean isDigit(char ch) {
        return ch >= '0' && ch <= '9';
    }
}
