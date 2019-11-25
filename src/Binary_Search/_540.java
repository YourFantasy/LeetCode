package Binary_Search;

public class _540 {
    public int singleNonDuplicate(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int mid = i + (j - i) / 2;

            if (nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1]) {
                return nums[mid];
            } else if (nums[mid] == nums[mid + 1]) {
                if ((j - mid) % 2 == 0) {
                    i = mid;
                } else {
                    j = mid - 1;
                }
            } else {
                if ((mid - i) % 2 == 0) {
                    j = mid;
                } else {
                    i = mid + 1;
                }
            }
        }
        return nums[i];
    }
}
