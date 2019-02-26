package Array;

import org.junit.Test;

public class _26 {

    @Test
    public void Test() {

    }

    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }

        }
        return i + 1;

    }
}
