package Array;

public class _80 {

    public int removeDuplicates(int[] nums) {
        int length = 0, i = 0, j = 1;
        while (i < nums.length) {
            if (j < nums.length && nums[i] == nums[j]) {
                if (j - i == 1) {
                    nums[length++] = nums[i];
                }
                j++;
            } else {
                nums[length++] = nums[j - 1];
                i = j;
                j++;
            }
        }
        return length;
    }
}
