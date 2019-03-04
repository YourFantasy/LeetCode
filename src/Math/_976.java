package Math;

import java.util.Arrays;

public class _976 {
    public int largestPerimeter(int[] A) {
        Arrays.sort(A);
        int len = A.length;
        if (len < 3)
            return 0;
        int i = len - 3, j = len - 2, k = len - 1;
        while (i >= 0) {
            if (A[i] + A[j] > A[k])
                return A[i] + A[j] + A[k];
            else {
                k = j;
                j = i;
                i -= 1;
            }
        }
        return 0;
    }
}
