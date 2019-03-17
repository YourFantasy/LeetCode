package Array;

public class _59 {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int cnt = 1;
        int j = 0;
        while (cnt <= n * n) {
            for (int i = j; i < n - j; i++)
                res[j][i] = cnt++;
            for (int i = j + 1; i < n - j; i++)
                res[i][n - j - 1] = cnt++;
            for (int i = n - j - 2; i >= j; i--)
                res[n - j - 1][i] = cnt++;
            for (int i = n - j - 2; i >= j + 1; i--)
                res[i][j] = cnt++;
            j++;
        }
        return res;
    }
}
