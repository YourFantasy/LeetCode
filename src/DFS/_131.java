package DFS;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class _131 {
    @Test
    public void test() {
        System.out.println(partition("aabdbde"));
    }

    private List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        dfs(s, res, temp, 0);
        return res;
    }

    private void dfs(String s, List<List<String>> res, List<String> temp, int begin) {

        for (int i = begin; i < s.length(); i++) {
            if (is_Palindrome(s,begin,i)) {
                temp.add(s.substring(begin, i + 1));
                dfs(s, res, temp, i + 1);
                if (temp.size() > 0) {
                    temp.remove(temp.size() - 1);
                }
            }
        }
        if (begin == s.length()) {
            res.add(new ArrayList<>(temp));
        }
    }

    private boolean is_Palindrome(String str, int i, int j) {
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
