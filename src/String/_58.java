package String;

import org.junit.Test;

public class _58 {
    @Test
    public void test(){
        String s="abc  ";
        System.out.println(lengthOfLastWord(s));
    }
    public int lengthOfLastWord(String s) {
        s=s.trim();
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                cnt = 0;
            } else {
                cnt++;
            }
        }
        return cnt;
    }
}
