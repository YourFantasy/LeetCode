package Binary_Search;

import org.junit.Test;

public class _69 {
    @Test
    public void Test() {
        System.out.println(mySqrt(Integer.MAX_VALUE));
    }

    public long mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        if (x < 4) {
            return 1;
        }
        long i = 0, j = x / 2;
        while (i <= j) {
            long mid = (i + j) / 2;
            long temp = mid * mid;
            if (x == temp) {
                return mid;
            } else if (x < temp) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        return j;
    }
}
