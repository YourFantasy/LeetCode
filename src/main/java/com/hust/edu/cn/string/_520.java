package com.hust.edu.cn.string;

public class _520 {
    public boolean detectCapitalUse(String word) {
        if (word.length() < 2) {
            return true;
        }
        char ch = word.charAt(0);
        int flag = 0;
        if (ch >= 'a' && ch <= 'z') {
            flag = 1;
        } else {
            if (word.charAt(1) >= 'A' && word.charAt(1) <= 'Z') {
                flag = 2;
            } else {
                flag = 3;
            }
        }
        if (flag == 1 && !(word.charAt(1) >= 'a' && word.charAt(1) <= 'z')) {
            return false;
        }
        for (int i = 2; i < word.length(); i++) {
            boolean b1 = !(word.charAt(i) >= 'a' && word.charAt(i) <= 'z');
            if (flag == 1) {
                boolean b = b1;
                if (b) {
                    return false;
                }
            }
            if (flag == 2) {
                if (!(word.charAt(i) >= 'A' && word.charAt(i) <= 'Z')) {
                    return false;
                }
            }
            if (flag == 3) {
                if (b1) {
                    return false;
                }
            }
        }
        return true;
    }


}
