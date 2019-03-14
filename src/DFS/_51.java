package DFS;

import java.util.ArrayList;
import java.util.List;

public class _51 {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        int[] nums = new int[n];
        search(res, 0, n, nums);
        return res;

    }

    List<String> plan(int[] nums, int n) {
        List<String> temp = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String s = "";
            for (int j = 0; j < n; j++) {
                if (j == nums[i])
                    s += "Q";
                else
                    s += ".";

            }
            temp.add(s);

        }
        return temp;
    }

    void search(List<List<String>> res, int n, int N, int[] nums) {
        if (n == N) {
            res.add(new ArrayList<>(plan(nums, N)));
            return;
        }
        for (int i = 0; i < N; i++) {
            nums[n] = i;
            boolean flag = true;
            for (int j = 0; j < n; j++) {
                if (nums[n] == nums[j] || n - j == nums[n] - nums[j] || n - j == nums[j] - nums[n]) {
                    flag = false;
                    break;
                }
            }
            if (flag)
                search(res, n + 1, N, nums);
        }
    }
}
