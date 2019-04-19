package Math;

import org.junit.Test;

public class _991{
    @Test
    public void test() {
        int x = 1, y = 1000;
        System.out.println(brokenCalc(x, y));
    }

    public int brokenCalc(int X, int Y) {
        int cnt = 0;
        if (Y <= X)
            return X - Y;
        while (X < Y) {
            if (Y % 2 == 0) {
                Y /= 2;
                cnt++;
            } else {
                Y = (Y + 1) / 2;
                cnt += 2;
            }
        }
        return X - Y + cnt;
    }
}
