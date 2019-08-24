package String;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class _151 {
    @Test
    public void test() {
        System.out.println(reverseWords("a  good    example"));
    }

    public String reverseWords(String s) {
        String[] strs = s.split(" ");
        StringBuilder res = new StringBuilder();
        for (int i = strs.length - 1; i >= 0; i--) {
            if(!"".equals(strs[i])){
                res.append(strs[i]);
                res.append(" ");
            }
        }
        return res.toString().trim();
    }
}
