package Math;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class _784 {
    List<String> result = new ArrayList<>();

    @Test
    public void Test() {
        String s = "hf2s3ed";
        letterCasePermutation(s);
        System.out.println(result);
    }

    public List<String> letterCasePermutation(String S) {
        dfs(S, 0, "");
        return result;
    }

    public void dfs(String s, int index, String temp) {
        if (index == s.length()) {
            result.add(temp);
            return;
        }
        if (Character.isLetter(s.charAt(index))) {
            dfs(s, index + 1, temp + Character.toLowerCase(s.charAt(index)));//将其转换为大写字母
            dfs(s, index + 1, temp + Character.toUpperCase(s.charAt(index)));//将其转换为小写字母
        } else {
            dfs(s, index + 1, temp + s.charAt(index));//如果是数字则不发生改变
        }

    }
}
