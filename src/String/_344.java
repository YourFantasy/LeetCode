package String;

import org.junit.Test;

import java.util.Arrays;

public class _344 {
    @Test
    public void Test() {
        String s = "Hello";
        System.out.println(reverseString(s));

    }

    public String reverseString(String s) {
        char[] ch = new char[s.length()];
        int j = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            ch[j++] = s.charAt(i);
        }

        return new String(ch);
    }
}
