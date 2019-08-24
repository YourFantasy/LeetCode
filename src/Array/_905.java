package Array;

public class _905 {
    public int[] sortArrayByParity(int[] A) {
        int i = 0, j = A.length - 1;
        if (i == j) {
            return A;
        }
        while (i < j) {
            while (i < j && A[i] % 2 == 0) {
                i++;
            }
            if (i < j) {
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            }
            j--;
            while (i < j && A[j] % 2 == 1) {
                j--;
            }
            if (i < j) {
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            }
            i++;

        }
        return A;
    }
}
