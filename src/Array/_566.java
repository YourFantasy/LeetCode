package Array;

public class _566 {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int x = nums.length;
        int y = nums[0].length;
        if (r * c != x * y) {
            return nums;
        }
        int[][] result = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                int temp = i * c + j;
                result[i][j] = nums[temp / y][temp % y];
            }
        }
        return result;
    }
}
