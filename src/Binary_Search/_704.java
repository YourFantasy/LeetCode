package Binary_Search;

public class _704 {
    public int search(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int mid = (i + j) / 2;
            int midnums = nums[mid];
            if (target == midnums)
                return mid;
            else if (target < midnums)
                j = mid - 1;
            else
                i = mid + 1;
        }
        return -1;
    }
}
