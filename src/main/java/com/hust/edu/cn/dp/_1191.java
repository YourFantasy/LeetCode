package com.hust.edu.cn.dp;

public class _1191 {
    public int kConcatenationMaxSum(int[] arr, int k) {
        int mod = 1000000007;
        int sum1 = 0;
        int maxSum1 = 0;
        int max = Integer.MIN_VALUE;
       int tempMax=0;
        for (int i = 0; i < arr.length; i++) {
           int temp=Math.max(tempMax+arr[i],arr[i]);
           tempMax=temp;
            max = Math.max(max, temp);
            sum1 += arr[i];
            maxSum1 = Math.max(maxSum1, sum1);
        }
        if (k == 1) {
            return Math.max(0, max) % mod;
        }
        int sum2 = 0;
        int maxSum2 = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            sum2 += arr[i];
            maxSum2 = Math.max(maxSum2, sum2);
        }
        if (sum1 <= 0) {
            return maxSum1 <= 0 ? (Math.max(0, max) % mod) : Math.max(max, maxSum1 + maxSum2) % mod;
        } else {
            int temp = maxSum1 + maxSum2;
            for (int i = k; i > 2; i--) {
                temp = (temp + sum1) % mod;
            }
            int res = Math.max(temp, max);
            return res % mod;
        }
    }
}
