package Math;

import java.util.ArrayList;
import java.util.List;

/**
 * 找规律题 ^(亦或运算) 相同为0，不同为1
 */
class _89 {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        int len = 1 << n;
        for (int i = 0; i < len; i++) {
            res.add(i ^ i >> 1);
        }
        return res;
    }
}
