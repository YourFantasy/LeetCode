package String;

import java.util.Arrays;

public class _387 {
    public int firstUniqChar(String s) {
        int[] nums = new int[26];
        Arrays.fill(nums, -1);
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            if (nums[index] != -1 && nums[index] != -2) {
                nums[index] = -2;
            } else if (nums[index] == -1) {
                nums[index] = i;
            }
        }
        int res = s.length();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != -1 && nums[i] != -2 && res > nums[i]) {
                res = nums[i];
            }
        }
        if (res == s.length()) {
            return -1;
        }
        return res;
    }
}
