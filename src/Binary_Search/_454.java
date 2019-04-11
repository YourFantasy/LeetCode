package Binary_Search;

import java.util.Arrays;
import java.util.HashMap;

public class _454 {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int n = A.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int total = A[i] + B[j];
                if (!map.containsKey(total))
                    map.put(total, 1);
                else
                    map.put(A[i] + B[j], map.get(total) + 1);
            }
        }
        int cnt = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                int sum = -(C[i] + D[j]);
                if (map.containsKey(sum))
                    cnt += map.get(sum);
            }
        return cnt;
    }
}
