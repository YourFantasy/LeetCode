package Math;

public class _238 {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int left = 1, right = 1;
        for (int i = 0; i < nums.length; i++) {
            res[i] = left;
            left *= nums[i];
        }
        for (int j = nums.length - 1; j >= 0; j--) {
            res[j] *= right;
            right *= nums[j];
        }
        return res;
    }
}
