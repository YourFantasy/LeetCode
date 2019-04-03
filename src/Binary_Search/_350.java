package Binary_Search;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        int[] res = new int[Math.min(nums1.length, nums2.length)];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            if (!map.containsKey(nums1[i]))
                map.put(nums1[i], 1);
            else
                map.put(nums1[i], map.get(nums1[i]) + 1);
        }
        int index = 0;
        for (int j = 0; j < nums2.length; j++)
            if (map.containsKey(nums2[j]) && map.get(nums2[j]) != 0) {
                res[index++] = nums2[j];
                map.put(nums2[j], map.get(nums2[j]) - 1);
            }
        return Arrays.copyOfRange(res, 0, index);
    }

    public int[] intersect2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);

        Arrays.sort(nums2);
        int i = 0, j = 0;
        int cnt = 0;
        while (i < nums1.length && j < nums2.length) {
            while (i < nums1.length && j < nums2.length && nums1[i] == nums2[j]) {
                nums1[cnt++] = nums1[i];
                i++;
                j++;
            }
            while (i < nums1.length && j < nums2.length && nums1[i] < nums2[j]) {
                i++;
            }
            while (i < nums1.length && j < nums2.length && nums1[i] > nums2[j]) {
                j++;
            }
        }
        return Arrays.copyOfRange(nums1, 0, cnt);
    }
}
