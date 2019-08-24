package Binary_Search;

public class _74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0) {
            return false;
        }
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            int j = 0, k = n - 1;
            while (j <= k) {
                int mid = j + (k - j) / 2;
                if (target == matrix[i][mid]) {
                    return true;
                } else if (target < matrix[i][mid]) {
                    k = mid - 1;
                } else {
                    j = mid + 1;
                }
            }
        }
        return false;
    }
}
