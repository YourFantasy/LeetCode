package com.hust.edu.cn.sort;

class _922 {
    public int[] sortArrayByParityII(int[] A) {
        int i = 0, j = A.length - 1;
        while (i < A.length && j >= 0) {
            while (i < A.length - 1 && A[i] % 2 == 0) {
                i += 2;
            }
            if (i < A.length - 1) {
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            }
            j -= 2;
            while (j >= 0 && A[j] % 2 == 1) {
                j -= 2;
            }
            if (j >= 0) {
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            }
            i += 2;
        }
        return A;
    }
}
