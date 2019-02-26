package Array;

import org.junit.Test;

public class _27 {

    @Test
    public void Test() {

    }

    public int removeElement(int[] nums, int val) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val)
                nums[index++] = nums[i];
        }
        return index;
    }
}
