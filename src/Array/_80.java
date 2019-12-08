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

    public int removeDuplicates1(int[] nums) {
        int index = 2;
        for (int j = 2; j < nums.length; j++) {
            if (nums[j] > nums[index - 2]) {
                nums[index++] = nums[j];
            }
        }
        return index;
    }
}
