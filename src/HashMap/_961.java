package HashMap;

import java.util.HashMap;

public class _961 {
    public int repeatedNTimes(int[] A) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            if (!map.containsKey(A[i])) {
                map.put(A[i], i);
            } else {
                return A[i];
            }
        }
        return A[0];
    }
}
