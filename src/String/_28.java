package String;

import org.junit.Test;

public class _28 {
    @Test
    public void test(){
        String haystack="3434a23";
        String needle="a";
        System.out.println(strStr(haystack,needle));
    }
    public int strStr(String haystack, String needle) {
        int len = needle.length();
        for (int i = 0; i <= haystack.length() - len; i++) {
            if (haystack.substring(i, i + len).equals(needle)) {
                return i;
            }
        }
        return -1;
    }
}
