package Array;

class _169 {
    public int majorityElement(int[] nums) {
        int count = 1;
        int key = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == key) {
                count++;
            } else {
                if (count > 0) {
                    count--;
                } else {
                    key = nums[i];
                    count = 1;
                }
            }
        }
        return key;
    }
}
