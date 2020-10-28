package com.hust.edu.cn.design;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class _547 {

    private static final Random random = new Random();

    @Test
    public void test() {
        int n = 5;
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (i == j) {
                    matrix[i][j] = 1;
                    continue;
                }
                int r = random.nextInt(20);
                if (r % 3 == 0) {
                    matrix[i][j] = 1;
                    matrix[j][i] = matrix[i][j];
                }
            }
        }
        System.out.println(findCircleNum(matrix));
    }

    public int findCircleNum(int[][] M) {
        int n = M.length;
        SearchSet set = new SearchSet(n);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (M[i][j] == 1) {
                    set.merge(j, i);
                }
            }
        }
        set.getCount();
        return set.kinds.size();
    }

    private static class SearchSet {
        private final int[] people;
        int len;
        List<List<Integer>> kinds = new ArrayList<>();

        public SearchSet(int n) {
            this.len = n;
            people = new int[len];
            for (int i = 0; i < len; i++) {
                people[i] = i;
            }
        }

        public void merge(int p1, int p2) {
            int e1 = search(p1);
            int e2 = search(p2);
            if (e1 != e2) {
                people[e1] = people[e2];
            }
        }

        public int search(int p) {
            if (p == people[p]) {
                return p;
            }
            people[p] = search(people[p]);
            return people[p];
        }

        public void getCount() {

            List<Integer> cnts = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                if (i == people[i]) {
                    cnts.add(i);
                }
            }
            for (Integer cnt : cnts) {
                List<Integer> temp = new ArrayList<>();
                for (int j = 0; j < len; j++) {
                    if (people[j] == cnt || people[people[j]] == cnt) {
                        temp.add(j);
                    }
                }

                kinds.add(temp);
            }
        }
    }
}

