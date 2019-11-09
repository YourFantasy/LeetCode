package String;

import java.util.Arrays;

public class _1156 {
    public int maxRepOpt1(String text) {
        int len = text.length();
        int[] count = new int[26];
        for (int i = 0; i < text.length(); i++) {
            count[text.charAt(i) - 'a']++;
        }
        int[] left = new int[len];
        int[] right = new int[len];
        Arrays.fill(left, 1);
        Arrays.fill(right, 1);
        int maxLen = 1;
        for (int i = 1; i < len; i++) {
            if (text.charAt(i) == text.charAt(i - 1)) {
                left[i] = left[i - 1] + 1;
            }
            maxLen = Math.max(maxLen, left[i]);
        }
        for (int i = len - 2; i >= 0; i--) {
            if (text.charAt(i) == text.charAt(i + 1)) {
                right[i] = right[i + 1] + 1;
            }
            maxLen = Math.max(maxLen, right[i]);
        }

        for (int i = 1; i < len - 1; i++) {
            if (count[text.charAt(i - 1) - 'a'] > left[i - 1]) {
                maxLen = Math.max(maxLen, left[i - 1] + 1);
            }
            if (count[text.charAt(i + 1) - 'a'] > right[i + 1]) {
                maxLen = Math.max(maxLen, right[i + 1]);
            }

            if (text.charAt(i - 1) == text.charAt(i + 1) && text.charAt(i) != text.charAt(i - 1)) {
                int sum = left[i - 1] + right[i + 1];
                if (count[text.charAt(i - 1) - 'a'] > sum) {
                    maxLen = Math.max(maxLen, sum + 1);
                } else {
                    maxLen = Math.max(maxLen, sum);
                }
            }
        }
        return maxLen;
    }
}