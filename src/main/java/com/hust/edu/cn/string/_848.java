package com.hust.edu.cn.string;

import org.junit.Test;

public class _848 {
    @Test
    public void test() {
        System.out.println(shiftingLetters("ruu", new int[]{Integer.MAX_VALUE, 9, 17}));
    }

//    public String shiftingLetters(String S, int[] shifts) {
//        StringBuilder sb = new StringBuilder();
//        long sum = 0;
//        for (int s : shifts)
//            sum += s;
//        long total = 0;
//        for (int i = 0; i < S.length(); i++) {
//            char ch = S.charAt(i);
//            int len = ch - 'a';
//            if (len + sum - total >= 26)
//                ch = (char) ('a' + (len + sum - total) % 26);
//            else
//                ch += sum - total;
//            total += shifts[i];
//            sb.append(ch);
//        }
//        return sb.toString();
//    }

    private String shiftingLetters(String S, int[] shifts) {
        shifts[shifts.length - 1] %= 26;
        for (int i = shifts.length - 2; i >= 0; i--) {
            shifts[i] = (shifts[i] % 26 + shifts[i + 1]) % 26;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            int len = S.charAt(i) - 'a' + shifts[i];
            sb.append((char) ('a' + len % 26));
        }
        return sb.toString();
    }
}
