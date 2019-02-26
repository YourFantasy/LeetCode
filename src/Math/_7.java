package Math;

import org.junit.Test;

public class _7 {

    @Test
    public void Test() {

    }

    public int reverse(int x) {
        int result = 0;
        while (x != 0) {
            int digit = x % 10;
            x /= 10;
            if (result > Integer.MAX_VALUE / 10 || result == Integer.MAX_VALUE / 10 && digit > 7)
                return 0;
            if (result < Integer.MIN_VALUE / 10 || result == Integer.MIN_VALUE / 10 && digit < -8)
                return 0;
            result = result * 10 + digit;
        }
        return result;
    }
}
