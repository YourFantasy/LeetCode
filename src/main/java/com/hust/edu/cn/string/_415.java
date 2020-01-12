package com.hust.edu.cn.string;

import org.junit.Test;

public class _415 {
    @Test
    public void Test() {
        String num1 = "345533333";
        String num2 = "35993349434543";
        System.out.println(addStrings(num1,num2));
    }

    private String addStrings(String num1, String num2) {
        StringBuilder result = new StringBuilder();
        int len1 = num1.length(), len2 = num2.length();
        int temp = 0;
        int len = Math.min(len1, len2);
        int length = len;
        int index=1;
        while (len > 0) {
            int a = num1.charAt(len1 - index) - '0';
            int b = num2.charAt(len2 - index) - '0';
            int c = (a + b + temp) % 10;
            temp = (a + b + temp) / 10;
            result.insert(0, c);
            len--;
            index++;
        }
        int i = len1 - length, j = len2 - length;
        while (i > 0) {
            int d = num1.charAt(i - 1) - '0';
            int e = (d + temp) % 10;
            temp = (d + temp) / 10;
            result.insert(0, e);
            i--;

        }
        while (j > 0) {
            int d = num2.charAt(j - 1) - '0';
            int e = (d + temp) % 10;
            temp = (d + temp) / 10;
            result.insert(0, e);
            j--;
        }
        if (temp > 0) {
            result.insert(0, temp);
        }
        return result.toString();
    }



}
