package Array;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class _287 {
    @Test
    public void Test() {
        int n = 50;
        int[] nums1 = new int[n];
        for (int i = 0; i < n; i++) {
            nums1[i] = (int) (Math.random() * n);
        }
        int[] nums2 = nums1;
        System.out.println(findDuplicate1(nums1));
        System.out.println(findDuplicate2(nums2));
    }

    public int findDuplicate1(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], i);
            } else {
                res = nums[i];
                break;
            }
        }
        return res;
    }

    public int findDuplicate2(int[] nums) {
        int index;
        int res = nums[0];
        for (int i = 0; i < nums.length; i++) {
            index = nums[Math.abs(nums[i]) - 1];
            if (index < 0) {
                res = Math.abs(nums[i]);
                break;
            } else {
                nums[Math.abs(nums[i]) - 1] *= -1;
            }
        }
        return res;
    }
}
