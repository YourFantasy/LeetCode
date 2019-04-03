package Array;

import java.util.Arrays;

public class _888 {
    public int[] fairCandySwap(int[] A, int[] B) {
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < A.length; i++)
            sum1 += A[i];
        for (int j = 0; j < B.length; j++)
            sum2 += B[j];
        int sub = (sum1 - sum2) / 2;
        Arrays.sort(A);
        Arrays.sort(B);
        int i = 0, j = 0;
        while (i < A.length && j < B.length) {
            if (A[i] - B[j] == sub)
                return new int[]{A[i], B[j]};
            else if (A[i] - B[j] < sub)
                i++;
            else j++;
        }
        return null;
    }
}
