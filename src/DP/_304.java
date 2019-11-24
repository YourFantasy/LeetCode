package DP;

public class _304 {
    private int[][] matrix;
    private int[][] temp;

    public _304(int[][] matrix) {
        this.matrix = matrix;
        if (matrix != null && matrix.length > 0) {
            temp = new int[matrix.length][matrix[0].length];
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    if (j > 0) {
                        temp[i][j] = matrix[i][j] + temp[i][j - 1];
                    } else {
                        temp[i][j] = matrix[i][j];
                    }
                }
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (row1 < 0 || row2 >= matrix.length || col1 < 0 || col2 >= matrix[0].length) {
            return 0;
        }
        int sum = 0;
        for (int i = row1; i <= row2; i++) {
            sum += matrix[i][col1] + temp[i][col2] - temp[i][col1];
        }
        return sum;
    }
}
