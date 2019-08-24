package Math;

public class _365 {
    public boolean canMeasureWater(int x, int y, int z) {
        if (x + y < z) {
            return false;
        }
        if (x + y + z == 0) {
            return true;
        }
        int m = get_divisor(x, y);
        if (z % m == 0) {
            return true;
        }
        return false;
    }

    int get_divisor(int m, int n) {
        if (m < n) {
            int temp = m;
            m = n;
            n = temp;
        }
        while (n > 0) {
            int by = m % n;
            m = n;
            n = by;
        }
        return m;
    }
}
