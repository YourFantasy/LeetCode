package Array;

import java.util.Arrays;
import java.util.HashMap;

public class _349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[] result = new int[Math.min(len1, len2)];
        int k = 0;
        for (int i = 0; i < len1; i++) {
            if (!map.containsKey(nums1[i])) {
                map.put(nums1[i], i);
            }
        }
        for (int j = 0; j < len2; j++) {
            if (map.containsKey(nums2[j])) {
                map.remove(nums2[j]);
                result[k++] = nums2[j];
            }
        }
        return Arrays.copyOfRange(result, 0, k);
    }
}
