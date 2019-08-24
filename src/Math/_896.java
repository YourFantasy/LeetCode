package Math;

public class _896 {
    public boolean isMonotonic(int[] A) {
        int flag = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i] > A[i - 1]) {
                flag = 1;
                break;
            }
            if (A[i] < A[i - 1]) {
                flag = -1;
                break;
            }
        }
        if (flag == 0) {
            return true;
        }
        for (int i = 1; i < A.length; i++) {
            if (flag == -1) {
                if (A[i] > A[i - 1]) {
                    return false;
                }
            }
            if (flag == 1) {
                if (A[i] < A[i - 1]) {
                    return false;
                }
            }
        }
        return true;
    }
}
