package com.hust.edu.cn.math;

public class _168 {
    /**
     * 26进制
     *
     * @param n
     * @return
     */
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        int m;
        char ch;
        while ((m = n - 1) > 25) {
            ch = (char) ('A' + m % 26);
            sb.append(ch);
            n = m / 26;
        }
        ch = (char) ('A' + m % 26);
        sb.append(ch);
        return sb.reverse().toString();
    }
}
