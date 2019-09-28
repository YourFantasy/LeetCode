package Math;

import java.util.ArrayList;
import java.util.List;

class _728 {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (isnum(i)) {
                list.add(i);
            }
        }
        return list;
    }

    private boolean isnum(int n) {
        int m = n;
        while (n > 0) {
            if (n % 10 == 0) {
                return false;
            }
            int tmep = n % 10;
            if (m % tmep != 0) {
                return false;
            }
            n = n / 10;
        }
        return true;
    }
}
