package Array;

public class _724 {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        if (n == 0 || n == 2) {
            return -1;
        }
        if (n == 1) {
            return 0;
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        if (sum - nums[0] == 0) {
            return 0;
        }
        int left = nums[0], right = sum;
        for (int i = 1; i < n; i++) {
            right -= nums[i];
            left += nums[i - 1];
            if (left == right) {
                return i;
            }
        }
        return -1;
    }
}
