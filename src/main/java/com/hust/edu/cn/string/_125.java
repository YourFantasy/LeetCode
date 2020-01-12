package com.hust.edu.cn.string;

class _125 {
    public boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            while (i < j && !isvalid(s.charAt(i))) {
                i++;
            }
            while (i < j && !isvalid(s.charAt(j))) {
                j--;
            }
            if (i < j && !isequal(s.charAt(i), s.charAt(j))) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    private boolean isvalid(char ch) {
        return ch >= 'a' && ch <= 'z' || ch >= 'A' && ch <= 'Z' || ch >= '0' && ch <= '9';

    }

    private boolean isequal(char ch1, char ch2) {
        if (ch1 >= 'A' && ch1 <= 'Z') {
            ch1 += 32;
        }
        if (ch2 >= 'A' && ch2 <= 'Z') {
            ch2 += 32;
        }
        return ch1 == ch2;
    }
}
