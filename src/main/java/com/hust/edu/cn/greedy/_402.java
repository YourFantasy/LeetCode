package com.hust.edu.cn.greedy;

import org.junit.Test;

import java.util.Stack;

public class _402 {
    @Test
    public void test() {
        String num = "31034819378194372";
        System.out.println(num.length());
        int k = 5;
        System.out.println(removeKdigits(num, k));
    }

    public String removeKdigits(String num, int k) {
        if (k == 0 || num == null || num.length() == 0) {
            return num;
        }
        if (k == num.length()) {
            return "0";
        }
        Stack<Character> stack = new Stack<>();
        int index = 0;
        while (k > 0 && index < num.length()) {
            if (stack.isEmpty() || num.charAt(index) >= stack.peek()) {
                stack.push(num.charAt(index));
                index++;
            } else {
                while (k > 0 && !stack.isEmpty() && num.charAt(index) < stack.peek()) {
                    stack.pop();
                    k--;
                }
                stack.push(num.charAt(index));
                index++;
            }
        }
        while (k == 0 && index != num.length()) {
            stack.push(num.charAt(index++));
        }
        while (k != 0) {
            stack.pop();
            k--;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.peek());
            stack.pop();
        }
        sb.reverse();
        int end = -1;
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) != '0') {
                break;
            }
            end = i;
        }
        if (end == -1) {
            return sb.toString();
        } else {
            return sb.toString().substring(end+1,sb.length()).length()==0?"0":sb.toString().substring(end+1,sb.length());

        }
    }
}
