package Math;

class _69 {
    public int mySqrt(int x) {
        long i = 1, j = x;
        while (i <= j) {
            long mid = i + (j - i) / 2;
            if (mid * mid <= x && (mid + 1) * (mid + 1) > x) {
                return (int) mid;
            } else if (mid * mid > x) {
                j = mid - 1;
            } else if (mid * mid < x) {
                i = mid + 1;
            }
        }
        return 0;
    }
}
