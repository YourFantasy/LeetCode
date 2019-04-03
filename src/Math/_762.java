package Math;

public class _762 {
    public int countPrimeSetBits(int L, int R) {
        //boolean[] notPrime = new boolean[R-L+1];
        int count = 0;
        for (int i = L; i <= R; i++) {
            if (is_Prime(count_number(i)))
                count++;
        }

        return count;
    }

    public boolean is_Prime(int a) {
        if (a == 1)
            return false;
        for (int i = 2; i * i <= a; i++) {
            if (a % i == 0)
                return false;
        }
        return true;
    }

    public int count_number(int a) {
        int cnt = 0;
        while (a > 0) {
            cnt += (a % 2);
            a /= 2;
        }
        return cnt;
    }
}
