package Array;

import java.util.Arrays;

class _888 {
    public int[] fairCandySwap(int[] A, int[] B) {
        int sum1 = 0;
        int sum2 = 0;
        for (int item : A) {
            sum1 += item;
        }
        for (int value : B) {
            sum2 += value;
        }
        int sub = (sum1 - sum2) / 2;
        Arrays.sort(A);
        Arrays.sort(B);
        int i = 0, j = 0;
        while (i < A.length && j < B.length) {
            if (A[i] - B[j] == sub) {
                return new int[]{A[i], B[j]};
            } else if (A[i] - B[j] < sub) {
                i++;
            } else {
                j++;
            }
        }
        return null;
    }
}
