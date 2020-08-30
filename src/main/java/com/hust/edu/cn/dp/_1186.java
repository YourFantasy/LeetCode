package com.hust.edu.cn.dp;

public class _1186 {
    public int maximumSum(int[] arr) {
        int res = arr[0];
        int cur1 = arr[0];
        int cur2 = arr[0];
        // cur1，正常情况下的连续子数组的最大和
        // cur2:正常情况下和删除一个节点比较的最大和
        // res：删与不删的最大和
        for (int i = 1; i < arr.length; i++) {
            // 选arr[i]  cur2+arr[i]
            cur2 = Math.max(cur2 + arr[i], cur1);
            cur1 = Math.max(arr[i] + cur1, arr[i]);
            res = Math.max(res, Math.max(cur1, cur2));

        }
        return res;
    }
}
