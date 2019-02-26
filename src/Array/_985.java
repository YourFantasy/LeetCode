package Array;

public class _985 {
    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int[] res = new int[A.length];
        for (int i = 0; i < queries.length; i++) {
            int val = queries[i][0];
            int index = queries[i][1];
            A[index] += val;
            for (int j = 0; j < A.length; j++) {
                if (A[j] % 2 == 0) {
                    res[i] += A[j];
                }
            }
        }
        return res;
    }
}
