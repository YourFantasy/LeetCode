package Array;

import java.util.ArrayList;
import java.util.List;

public class _54 {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int m = matrix.length;
        if (m == 0)
            return res;
        int n = matrix[0].length;
        int l = 0, r = n - 1, u = 0, d = m - 1;
        while (true) {
            for (int i = l; i <= r; i++)
                res.add(matrix[u][i]);
            if (++u > d)
                break;
            for (int i = u; i <= d; i++)
                res.add(matrix[i][r]);
            if (--r < l)
                break;
            for (int i = r; i >= l; i--)
                res.add(matrix[d][i]);
            if (--d < u)
                break;
            for (int i = d; i >= u; i--)
                res.add(matrix[i][l]);
            if (++l > r)
                break;
        }
        return res;
    }
}
