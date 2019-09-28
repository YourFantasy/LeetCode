package Math;

class _908 {
    public int smallestRangeI(int[] A, int K) {
        if (A.length == 0) {
            return 0;
        }
        int max = A[0], min = A[0];
        for (int i = 1; i < A.length; i++) {
            max = Math.max(max, A[i]);
            min = Math.min(min, A[i]);
        }
        return Math.max((max - min - 2 * K), 0);
    }
}
