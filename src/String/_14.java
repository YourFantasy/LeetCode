package String;

import org.junit.Test;

public class _14 {
    @Test
    public void Test() {
        String[] strs = {"flower", "flow", "floght"};
        System.out.println(longestCommonPrefix(strs));
    }

    private String longestCommonPrefix(String[] strs) {
        StringBuilder s = new StringBuilder();

        if (strs.length == 0) {
            return s.toString();
        }

        int len = strs.length;
        int maxlength = strs[0].length();
        for (int i = 1; i < len; i++) {
            int cnt = 0;
            for (int j = 0; j < Math.min(strs[i].length(), maxlength); j++) {
                if (strs[i - 1].charAt(j) != strs[i].charAt(j)) {
                    break;
                } else {
                    cnt++;
                }

            }
            maxlength = Math.min(maxlength, cnt);
        }

        for (int i = 0; i < maxlength; i++) {
            s.append(strs[0].charAt(i));
        }
        return s.toString();
    }

    public String longestCommonPrefix1(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int minLen = strs[0].length();
        int index = 0;
        for (int i = 1; i < strs.length; i++) {
            if (strs[i].length() < minLen) {
                minLen = strs[i].length();
                index = i;
            }
        }

        int len = 1;
        int res = 0;

        while (len <= minLen) {
            boolean flag = true;
            for (int i = 1; i < strs.length; i++) {
                if (strs[i].charAt(len - 1) != strs[i - 1].charAt(len - 1)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                res = len;
                len++;
            } else {
                break;
            }
        }
        return strs[index].substring(0, res);
    }
}
