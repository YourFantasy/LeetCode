package Math;

public class _263 {
    public boolean isUgly(int num) {
        if (num == 1)
            return true;
        while (num > 1) {
            if (num % 2 != 0 && num % 3 != 0 && num % 5 != 0)
                return false;
            if (num % 2 == 0)
                num /= 2;
            if (num % 3 == 0)
                num /= 3;
            if (num % 5 == 0)
                num /= 5;
        }
        if (num == 1)
            return true;
        return false;
    }
}
