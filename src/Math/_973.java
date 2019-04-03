package Math;

import org.junit.Test;

public class _973 {
    @Test
    public void test() {
        int[][] points = {{1, 2}, {3, 4}, {-1, 2}, {3, 1}, {-2, -3}};
        int[][] res = kClosest(points, 3);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i][0] + "," + res[i][1]);
        }
    }

    public int[][] kClosest(int[][] points, int K) {
        int len = points.length;
        int[][] res = new int[K][2];
        int[] temp = new int[len];
        for (int i = 0; i < len; i++) {
            int sum = squares_sum(points[i][0], points[i][1]);
            temp[i] = sum;
        }
        boolean[] flag = new boolean[len];
        int[] index = new int[len];
        while (K > 0) {
            int min = Integer.MAX_VALUE, j = -1;
            for (int i = 0; i < len; i++) {
                if (min > temp[i] && !flag[i]) {
                    min = temp[i];
                    j = i;
                }
            }
            flag[j] = true;
            index[--K] = j;
        }
        for (int i = 0; i < res.length; i++) {
            res[i][0] = points[index[i]][0];
            res[i][1] = points[index[i]][1];
        }
        return res;

    }

    int squares_sum(int a, int b) {
        return a * a + b * b;
    }
}
