package com.hust.edu.cn.array;

class _985 {
    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int[] res = new int[A.length];
        for (int i = 0; i < queries.length; i++) {
            int val = queries[i][0];
            int index = queries[i][1];
            A[index] += val;
            for (int value : A) {
                if (value % 2 == 0) {
                    res[i] += value;
                }
            }
        }
        return res;
    }
}
