package HashMap;

import java.util.Arrays;

class _242 {
    public boolean isAnagram(String s, String t) {
        int len1 = s.length();
        int len2 = s.length();
        if (len2 > len1) {
            return false;
        }
        char[] ch1 = s.toCharArray();
        Arrays.sort(ch1);
        s = new String(ch1);
        char[] ch2 = t.toCharArray();
        Arrays.sort(ch2);
        t = new String(ch2);
        for (int i = 0; i + len2 <= len1; i++) {
            if (t.equals(s.substring(i, i + len2))) {
                return true;
            }
        }
        return false;
    }
}
