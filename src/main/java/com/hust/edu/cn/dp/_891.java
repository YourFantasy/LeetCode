package com.hust.edu.cn.dp;

import java.util.Arrays;

class _891 {
    public int sumSubseqWidths(int[] A) {
        Arrays.sort(A);
        int[] dp=new int[A.length];
        dp[0]=0;
        for (int i=1;i<A.length;i++){
            int temp=0;
            for (int j=0;j<i;j++){
                temp+=Math.pow(2,(i-j-1))*(A[i]-A[j]);
            }
            dp[i]=temp;

        }
        return dp[A.length-1];
    }
}
