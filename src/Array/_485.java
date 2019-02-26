package Array;

public class _485 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int[] dp = new int[nums.length];
        if (nums[0] == 1)
            dp[0] = 1;
        int max = dp[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == 1)
                dp[i] = dp[i - 1] + 1;
            else
                dp[i] = 0;

            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
