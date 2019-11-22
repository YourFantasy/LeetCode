package Math;

import java.util.HashSet;
import java.util.Set;

public class _260 {
    /**
     * 暴力Hash
     *
     * @param nums
     * @return
     */
    public int[] singleNumber(int[] nums) {
        int[] res = new int[2];
        Set<Integer> set = new HashSet<>();
        for (int a : nums) {
            if (!set.contains(a)) {
                set.add(a);
            } else {
                set.remove(a);
            }
        }
        int index = 0;
        for (int s : set) {
            res[index++] = s;
        }
        return res;
    }

    /**
     * 使用位运算
     *
     * @param nums
     * @return
     */
    public int[] singleNumber1(int[] nums) {
        int[] res = new int[2];
        int temp = 0;
        for (int a : nums) {
            temp ^= a;
        }
        int index = getIndex(temp);
        for (int a : nums) {
            if (isBit(index, a)) {
                res[0] ^= a;
            } else {
                res[1] ^= a;
            }
        }
        return res;
    }

    public boolean isBit(int index, int m) {
        m >>= index;
        return (m & 1) == 1;
    }

    public int getIndex(int m) {
        int index = 0;
        while ((m & 1) != 1 && index < 32) {
            index++;
            m >>= 1;
        }
        return index;
    }
}
