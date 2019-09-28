package Array;

class _832 {
    public int[][] flipAndInvertImage(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            for (int j = 0, k = A[i].length - 1; j < k; j++, k--) {
                int temp = A[i][k];
                A[i][k] = A[i][j];
                A[i][j] = temp;
            }
        }
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                A[i][j] = (A[i][j] - 1) * (A[i][j] - 1);
            }
        }
        return A;
    }
}
