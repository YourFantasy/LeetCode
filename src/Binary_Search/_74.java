package Binary_Search;

class _74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0) {
            return false;
        }
        int n = matrix[0].length;
        for (int[] ints : matrix) {
            int j = 0, k = n - 1;
            while (j <= k) {
                int mid = j + (k - j) / 2;
                if (target == ints[mid]) {
                    return true;
                } else if (target < ints[mid]) {
                    k = mid - 1;
                } else {
                    j = mid + 1;
                }
            }
        }
        return false;
    }
}
