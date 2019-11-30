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
            switch (index) {
                case 0:
                    s[i] = "abc";
                    break;
                case 1:
                    s[i] = "def";
                    break;
                case 2:
                    s[i] = "ghi";
                    break;
                case 3:
                    s[i] = "jkl";
                    break;
                case 4:
                    s[i] = "mno";
                    break;
                case 5:
                    s[i] = "pqrs";
                    break;
                case 6:
                    s[i] = "tuv";
                    break;
                case 7:
                    s[i] = "wxyz";
                    break;
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
