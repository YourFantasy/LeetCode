package Math;

public class _1001 {
    public int bitwiseComplement(int N) {
        if (N == 0) {
            return 1;
        }
        int res = 0;
        int b = 1;
        while (N > 0) {
            int m = (N % 2 + 1) % 2;
            res += m * b;
            b *= 2;
            N /= 2;

        }
        return res;
    }
}
