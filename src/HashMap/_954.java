package HashMap;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author YourFantasy
 * @date 2019/9/19 7:22 下午
 * @description: 二倍数对数组
 */
public class _954 {
    @Test
    public void test() {
        int[] A = {4, -2, 2, -4};
        boolean res = canReorderDoubled(A);
    }

    public boolean canReorderDoubled(int[] A) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int value : A) {
            if (!map.containsKey(value)) {
                map.put(value, 1);
            } else {
                map.put(value, map.get(value) + 1);
            }
        }
        Arrays.sort(A);
        for (int i = 0; i < A.length; i++) {
            if (map.get(A[i]) == 0) {
                continue;
            }
            if (A[i] < 0) {
                if (A[i] % 2 == 1) {
                    return false;
                } else {
                    if (!map.containsKey(A[i] / 2) || map.get(A[i] / 2) == 0) {
                        return false;
                    } else {
                        map.put(A[i], map.get(A[i]) - 1);
                        map.put(A[i] / 2, map.get(A[i] / 2) - 1);

                    }
                }
            } else {
                if (!map.containsKey(A[i] * 2) || map.get(A[i] * 2) == 0) {
                    return false;
                } else {
                    map.put(A[i], map.get(A[i]) - 1);
                    map.put(A[i] * 2, map.get(A[i] * 2) - 1);
                }
            }
        }
        for (Integer i : A) {
            if (map.get(i) != 0) {
                return false;
            }
        }
        return true;
    }
}
