package DFS;

import java.util.ArrayList;
import java.util.List;

public class _22 {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        dfs(n, res, 0, 0, "");
        return res;
    }

    public void dfs(int n, List<String> res, int cnt1, int cnt2, String temp) {
        if (cnt1 > n || cnt2 > n) {
            return;
        }
        if (cnt1 == n && cnt2 == n) {
            res.add(temp);
            return;
        }
        if (cnt1 >= cnt2) {
            dfs(n, res, cnt1 + 1, cnt2, temp + "(");
            dfs(n, res, cnt1, cnt2 + 1, temp + ")");
        }
    }
}
