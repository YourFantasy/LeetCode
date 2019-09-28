package Math;

public class _9 {

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int m = x;
        int n = 0;
        while (x != 0) {
            n = n * 10 + x % 10;
            x /= 10;
        }
        return m == n;
    }
}
