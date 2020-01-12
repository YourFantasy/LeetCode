package com.hust.edu.cn.hashMap;

import java.util.Arrays;
import java.util.HashMap;

class _268 {

    public int missingNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int result = -1;
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length + 1; i++) {
            if (!map.containsKey(i)) {
                result = i;
                break;
            }
        }
        return result;
    }

    public int missingNumber1(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] != i) {
                return i;
            }
        }
        return n;
    }

    public int missingNumber2(int[] nums) {
        int sum = 0, n = nums.length;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        return n * (n + 1) / 2 - sum;
    }

    public int missingNumber3(int[] nums) {
        int n = nums.length;
        int res = n;
        for (int i = 0; i < n; i++) {
            res ^= nums[i];
            res ^= i;
        }
        return res;
    }


}
