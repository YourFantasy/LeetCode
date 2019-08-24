package String;

import org.junit.Test;

public class _345 {
    @Test
    public void Test() {
        String s = "leetcode";
        System.out.print(reverseVowels(s));
    }

    public String reverseVowels(String s) {
        char[] ch = new char[s.length()];
        int i = 0, j = s.length() - 1;
        while (i <= j) {
            if (!is_vowel(s.charAt(i)) && !is_vowel(s.charAt(j))) {
                ch[i] = s.charAt(i++);
                ch[j] = s.charAt(j++);
                continue;
            }
            if (!is_vowel(s.charAt(i)) && is_vowel(s.charAt(j))) {
                ch[i] = s.charAt(i);
                i++;
                continue;
            }
            if (is_vowel(s.charAt(i)) && !is_vowel(s.charAt(j))) {
                ch[j] = s.charAt(j);
                j--;
                continue;
            }
            if (is_vowel(s.charAt(i)) && is_vowel(s.charAt(j))) {
                ch[i] = s.charAt(j);
                ch[j] = s.charAt(i);
                i++;
                j--;
                continue;
            }
        }
        return new String(ch);
    }

    boolean is_vowel(char ch) {
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {
            return true;
        }
        return false;
    }
}
