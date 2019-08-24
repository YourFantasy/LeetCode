package Math;

public class _693 {
    public boolean hasAlternatingBits(int n) {
        int temp = n % 2;
        n /= 2;
        while (n > 0) {
            int m = n % 2;
            if (m == temp) {
                return false;
            }
            temp = m;
            n /= 2;
        }
        return true;
    }
}
