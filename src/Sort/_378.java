package Sort;

public class _378 {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int min = matrix[0][0];
        int max = matrix[n - 1][n - 1];
        while (min < max) {
            int mid = (max + min) >> 1;
            int cnt = getCnt(matrix, mid, n, n);
            if (cnt < k) {
                min = mid + 1;
            } else {
                max = mid;
            }
        }
        return min;
    }

    /**
     * 在matrxi找到比target小的元素个数
     *
     * @param matrix
     * @param target
     * @param row
     * @param column
     * @return
     */
    public int getCnt(int[][] matrix, int target, int row, int column) {
        int i = 0, j = column - 1;
        int res = 0;
        while (i < row && j >= 0) {
            if (target >= matrix[i][j]) {
                res += j + 1;
                i++;
            } else {
                j--;
            }
        }
        return res;
    }
}
