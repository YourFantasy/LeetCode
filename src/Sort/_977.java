package Sort;

public class _977 {
    public int[] sortedSquares(int[] A) {
        int[] res = new int[A.length];
        int i = 0, j = A.length - 1, index = A.length - 1;
        while (i < j) {
            while (i < j && (A[i] * A[i] <= A[j] * A[j])) {
                res[index--] = A[j] * A[j];
                j--;
            }
            while (i < j && (A[i] * A[i] > A[j] * A[j])) {
                res[index--] = A[i] * A[i];
                i++;
            }
        }
        res[index] = A[i] * A[i];
        return res;
    }
}
