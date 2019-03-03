package Binary_Search;

public class _153 {
    public int findMin(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int mid = i + (j - i) / 2;
            if (nums[mid] > nums[j])
                i = mid + 1;
            else
                j = mid;
        }
        return nums[i];
    }
}
