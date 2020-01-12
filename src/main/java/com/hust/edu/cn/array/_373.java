package com.hust.edu.cn.array;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _373 {
    private List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<>();
        int len1 = nums1.length, len2 = nums2.length;
        if (len1 * len2 == 0) {
            return res;
        }
        k = Math.min(len1 * len2, k);
        int[] temp = new int[len1];
        for (int i = 0; i < k; i++) {
            int min = Integer.MAX_VALUE;
            int index = 0;
            for (int j = 0; j < len1; j++) {
                if (temp[j] < len2 && nums2[temp[j]] + nums1[j] < min) {
                    min = nums2[temp[j]] + nums1[j];
                    index = j;
                }
            }
            List<Integer> list = new ArrayList<>();
            list.add(nums1[index]);
            list.add(nums2[temp[index]]);
            res.add(list);
            temp[index]++;
        }
        return res;
    }

    @Test
    public void test() {
        int len1 = (int) (Math.random() * 20);
        int len2 = (int) (Math.random() * 20);
        int[] nums1 = new int[len1];
        int[] nums2 = new int[len2];
        for (int i = 0; i < len1; i++) {
            nums1[i] = (int) (Math.random() * 20);
        }
        for (int i = 0; i < len2; i++) {
            nums2[i] = (int) (Math.random() * 20);
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        System.out.println(kSmallestPairs(nums1, nums2, (int) (Math.random() * 20)));
    }
}
