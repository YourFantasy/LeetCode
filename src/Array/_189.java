package Array;

public class _189 {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        if (len == 0 || len == 1)
            return;
        k = k % len;
        while (k > 0) {
            int temp = nums[0];
            nums[0] = nums[len - 1];
            for (int i = 1; i < len; i++) {
                int tmp = nums[i];
                nums[i] = temp;
                temp = tmp;
            }
            k--;
        }
    }

    public void rotate2(int[] nums, int k) {
        int len = nums.length;
        if (len == 1 || len == 0)
            return;
        k = k % len;
        reverse(nums, 0, len - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, len - 1);
    }

    public void reverse(int[] nums, int i, int j) {
        //int i=begin,j=end;
        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}
