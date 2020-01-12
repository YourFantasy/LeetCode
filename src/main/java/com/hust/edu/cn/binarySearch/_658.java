package com.hust.edu.cn.binarySearch;

import java.util.ArrayList;
import java.util.List;

public class _658 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();
        int i = 0, j = arr.length - k;
        while (i < j) {
            int mid = i + (j - i) / 2;
            if (x - arr[mid] > arr[mid + k] - x) {
                i = mid + 1;
            } else {
                j = mid;
            }
        }

        for (int q = i; q < k + i; q++) {
            res.add(arr[q]);
        }
        return res;
    }
}
