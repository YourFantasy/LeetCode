package Math;

import org.junit.Test;

public class _878 {
    @Test
    public void test() {
        System.out.println(nthMagicalNumber(1000000000, 40000, 40000));

    }

    private int nthMagicalNumber(int N, int A, int B) {
        int mode=1000000007;
        int multiple = A * B / max_divisor(A, B);
        for (int i = Math.min(A, B); i < multiple; i++) {
            if (i % A == 0 || i % B == 0) {
                N--;
                if (N == 0) {
                    return i;
                }
            }

        }
        int k = 0;
        for (int i = multiple; i < 2 * multiple; i++) {
            if (i % A == 0 || i % B == 0) {
                k++;
            }
        }
        System.out.println(multiple);
        System.out.println(k);
        int m = (N + k - 1) / k;
        int n = (N + k - 1) % k;
        System.out.println(m);
        for (long i = m * multiple; i <= (m + 1) * multiple; i++) {
            if (i % A == 0 || i % B == 0) {
                if (n == 0) {
                    System.out.println(i);
                    return (int) (i % mode);
                }
                n--;
            }
        }
        return 0;

    }

    private int max_divisor(int x, int y) {
        int temp;
        if (x > y) {
            temp = x;
            x = y;
            y = temp;
        }
        while (x > 0) {
            temp = y % x;
            y = x;
            x = temp;
        }
        return y;
    }
}
