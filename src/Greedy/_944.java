package Greedy;

import org.junit.Test;

public class _944 {
    @Test
    public void test() {
        String[] A = {"cba", "aaf", "ghi"};
        System.out.print(minDeletionSize(A));
    }

    public int minDeletionSize(String[] A) {
        int cnt = 0;
        for (int i = 0; i < A[0].length(); i++) {
            if (!is_Ascend(A, i)) {
                cnt++;
            }
        }
        return cnt;
    }

    boolean is_Ascend(String[] A, int column) {
        for (int i = 1; i < A.length; i++) {
            if (A[i].charAt(column) < A[i - 1].charAt(column)) {
                return false;
            }
        }
        return true;
    }
}
