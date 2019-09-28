package DFS;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class _17 {
    @Test
    public void test() {
        System.out.println(letterCombinations("723"));
    }

    private List<String> letterCombinations(String digits) {
        int n = digits.length();
        List<String> list = new ArrayList<>();
        if (n == 0) {
            return list;
        }
        String[] s = new String[n];
        for (int i = 0; i < n; i++) {
            int index = digits.charAt(i) - '2';
            if (index == 0) {
                s[i] = "abc";
            }
            if (index == 1) {
                s[i] = "def";
            }
            if (index == 2) {
                s[i] = "ghi";
            }
            if (index == 3) {
                s[i] = "jkl";
            }
            if (index == 4) {
                s[i] = "mno";
            }
            if (index == 5) {
                s[i] = "pqrs";
            }
            if (index == 6) {
                s[i] = "tuv";
            }
            if (index == 7) {
                s[i] = "wxyz";
            }
        }
        dfs(s, n, 0, list, "");
        return list;
    }

    private void dfs(String[] s, int n, int begin, List<String> list, String temp) {
        if (begin == n) {
            list.add(temp);
            return;
        }
        for (int j = 0; j < s[begin].length(); j++) {
            dfs(s, n, begin + 1, list, temp + s[begin].charAt(j));
        }
    }
}
