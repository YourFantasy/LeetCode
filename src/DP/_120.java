package DP;

import java.util.List;

public class _120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int len = triangle.size();
        int[] dp = new int[len];
        dp[0] = triangle.get(0).get(0);
        for (int i = 0; i < len-1; i++) {
            List<Integer> list = triangle.get(i);
            for (int j = 0; j < list.size(); j++) {
            }
        }
        return dp[len-1];
    }


}
