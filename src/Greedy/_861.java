package Greedy;

import org.junit.Test;

public class _861 {

    @Test
    public void test() {
        int[][] A = {{0, 0, 1, 1}, {1, 0, 1, 0}, {1, 1, 0, 0}};
        System.out.println(matrixScore(A));
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                System.out.print(A[i][j] + ",");
            }
            System.out.println();
        }
    }

    public int matrixScore(int[][] A) {
        int res = 0;
        int m = A.length;
        int n = A[0].length;
        for (int j = 0; j < m; j++) {
            if (A[j][0] == 0) {
                reverse_row(A, j);
            }
        }
        for (int i = 1; i < n; i++) {
            if (column_sum(A, i) < (m + 1) / 2) {
                reverse_column(A, i);
            }
        }
        for (int i = 0; i < m; i++) {
            int temp = 0, x = 1;
            for (int j = n - 1; j >= 0; j--) {
                temp += x * A[i][j];
                x *= 2;
            }
            res += temp;
        }
        return res;
    }

    int column_sum(int[][] A, int column) {
        int res = 0;
        for (int i = 0; i < A.length; i++) {
            res += A[i][column];
        }
        return res;
    }

    void reverse_row(int[][] A, int row) {
        for (int i = 0; i < A[0].length; i++) {
            A[row][i] = (A[row][i] + 1) % 2;
        }
    }

    void reverse_column(int[][] A, int column) {
        for (int i = 0; i < A.length; i++) {
            A[i][column] = (A[i][column] + 1) % 2;
        }
    }
}
