package DP;

public class _387 {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0)
            return 1;
        int result = 10;
        int temp = 9;
        for (int i = 1; i < n; i++) {
            result += temp * (10 - i);
            temp *= (10 - i);
        }
        return result;
    }
}
