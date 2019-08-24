package Binary_Search;

public class _81 {
    public boolean search(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (target == nums[mid]) {
                return true;
            }
            if (nums[mid] > nums[i]) {
                if (target >= nums[i] && target <= nums[mid]) {
                    j = mid;
                } else {
                    i = mid + 1;
                }
            } else if (nums[mid] < nums[i]) {
                if (target >= nums[mid] && target <= nums[j]) {
                    i = mid;
                } else {
                    j = mid - 1;
                }
            } else {
                i += 1;
            }
        }
        return false;
    }
}
