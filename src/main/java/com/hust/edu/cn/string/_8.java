package com.hust.edu.cn.string;

import org.junit.Test;

public class _8 {
    @Test
    public void test() {
        String str = "+42";
        System.out.println(myAtoi(str));
    }

    public int myAtoi(String str) {
        int index = getIndex(str);
        if (index == -1) {
            return 0;
        }
        if (!(isDigit(str.charAt(index)) || str.charAt(index) == '-' || str.charAt(index) == '+')) {
            return 0;
        }
        boolean flag = true;
        StringBuilder sb = new StringBuilder();
        if (str.charAt(index) == '-' || str.charAt(index) == '+') {
            if (index == str.length() - 1 || !Character.isDigit(str.charAt(index + 1))) {
                return 0;
            }
            flag = str.charAt(index) == '+';
            sb.append(str.charAt(index));
            index++;
        }
        for (int i = index; i < str.length(); i++) {
            if (isDigit(str.charAt(i))) {
                sb.append(str.charAt(i));
            } else {
                break;
            }
        }
        try {
            return Integer.parseInt(sb.toString());
        } catch (Exception e) {
            return flag ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }

    }

    private boolean isDigit(char ch) {
        return ch >= '0' && ch <= '9';
    }

    private int getIndex(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ' ') {
                return i;
            }
        }
        return -1;
    }
}
