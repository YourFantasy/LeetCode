package Math;

class _461 {
    public int hammingDistance(int x, int y) {
        int c = x ^ y;
        int cnt = 0;
        while (c > 0) {
            if (c % 2 == 1) {
                cnt++;
            }
            c /= 2;
        }
        return cnt;

    }
}
