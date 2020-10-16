package com.hust.edu.cn.string;

public class _556 {

    public int nextGreaterElement(int n) {
        char[] digits = (String.valueOf(n)).toCharArray();
        int i = digits.length - 1;
        for (; i > 0; i--) {
            if (digits[i] > digits[i - 1]) {
                break;
            }
        }
        if (i == 0) {
            return -1;
        }
        for (int k = digits.length - 1; k >= i; k--) {
            if (digits[k] > digits[i - 1]) {
                char temp = digits[k];
                digits[k] = digits[i - 1];
                digits[i - 1] = temp;
                break;
            }
        }
        reverse(digits, i, digits.length - 1);
        try {
            return Integer.parseInt(new String(digits));
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private void reverse(char[] digits, int begin, int end) {
        while (begin < end) {
            char temp = digits[begin];
            digits[begin] = digits[end];
            digits[end] = temp;
            begin++;
            end--;
        }
    }
}
