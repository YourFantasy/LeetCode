package Array;

public class _73 {
    /**
     * 第一行，第一列单独拿出来讨论
     * 核心思想:如果matrix[i][j]==0的话，将该元素所在行和列的第一个元素分别置为0
     * 从行开始遍历，如果该行的第一个元素为0，则将行元素全部置为0
     * 从列开始遍历，如果该列的第一个元素为0，则将该列元素全部置为0
     * 最后分别判断第一行和第一列，看是否置为0(判断第一行和第一列是否存在0要先单独拿出来判断，如果后来再判断的话就无法知道第一行或第一列存在0的是原先就存在的还是经过上述操作而变成的)
     *
     * @param matrix
     */
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean rflag = false;
        for (int i = 0; i < n; i++)
            if (matrix[0][i] == 0) {
                rflag = true;
                break;
            }
        boolean cflag = false;
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                cflag = true;
                break;
            }
        }
        for (int i = 1; i < m; i++)
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        for (int i = 1; i < n; i++)
            if (matrix[0][i] == 0) {
                for (int j = 0; j < m; j++)
                    matrix[j][i] = 0;
            }
        for (int i = 1; i < m; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 0; j < n; j++)
                    matrix[i][j] = 0;
            }
        }
        if (rflag) {
            for (int i = 0; i < n; i++)
                matrix[0][i] = 0;
        }
        if (cflag) {
            for (int j = 0; j < m; j++)
                matrix[j][0] = 0;
        }
    }
}
