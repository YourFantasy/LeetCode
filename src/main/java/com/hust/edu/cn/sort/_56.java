package com.hust.edu.cn.sort;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _56 {
    @Test
    public void test(){
        int[][] nums={{1,3},{2,6},{8,10},{15,18}};
        System.out.println(Arrays.deepToString(merge(nums)));
    }
    public int[][] merge(int[][] intervals) {
        int m = intervals.length;
        int[] begin = new int[m];
        int[] end = new int[m];
        for (int i = 0; i < m; i++) {
            begin[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }

        Arrays.sort(begin);
        Arrays.sort(end);
        List<int[]> res = new ArrayList<>();
        for (int i = 0, j = 0; i < m; i++) {
            if (i == m - 1 || begin[i + 1] > end[i]) {
                res.add(new int[]{begin[j], end[i]});
                j = i + 1;
            }

        }
        return res.toArray(new int[res.size()][0]);
    }

}
