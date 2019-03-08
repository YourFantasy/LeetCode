package Math;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _368 {
    @Test
    public void Test() {
        int[] nums = {3, 4, 16, 8};
        System.out.println(largestDivisibleSubset(nums));
    }

    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums.length == 0)
            return res;
        Arrays.sort(nums);
        int[] dp = new int[nums.length];
        int[] index = new int[nums.length];
        dp[0] = 1;
        index[0] = -1;
        int max_len = 1;
        int last = 0;
        for (int i = 1; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] % nums[j] == 0 && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    index[i] = j;
                }


            }
            if (dp[i] == 0) {
                dp[i] = 1;
                index[i] = -1;
            }
            if (max_len < dp[i]) {
                max_len = dp[i];
                last = i;
            }
        }
        while (last >= 0) {
            res.add(nums[last]);
            last = index[last];
        }
        return res;
    }
}
