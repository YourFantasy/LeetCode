package Math;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class _970 {
    @Test
    public void test() {
        System.out.print(powerfulIntegers(2, 3, 100));
    }

    private List<Integer> powerfulIntegers(int x, int y, int bound) {
        List<Integer> res = new ArrayList<>();
        if (bound == 0) {
            return res;
        }
        int i = get_times(x, bound);
        int j = get_times(y, bound);
        System.out.println(i + "," + j);
        for (int k = 0; k <= i; k++) {
            for (int t = 0; t <= j; t++) {
                int sum = Exponential(x, k) + Exponential(y, t);
                if (sum <= bound) {
                    res.add(sum);
                }
            }
        }
        return res;

    }

    private int get_times(int a, int bound) {
        if (a == 1) {
            return 0;
        }
        int i = 0;
        int b = a;
        while (b <= bound) {
            b *= a;
            i++;
        }
        return i;
    }

    private int Exponential(int a, int index) {
        int res = 1;
        for (int i = 0; i < index; i++) {
            res *= a;
        }
        return res;
    }
}
