package Binary_Search;

public class _153 {
    public int findMin(int[] nums) {
        int i = 0, j = nums.length - 1;
        if (nums[j] > nums[i])
            return nums[i];
        while (i + 1 < j) {
            int mid = i + ((j - i) >> 1);
            if (nums[mid] > nums[i])
                i = mid;
            else
                j = mid;
        }
        return Math.min(nums[i], nums[j]);
    }
}
