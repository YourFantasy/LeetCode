package Math;

public class _672 {
    public int flipLights(int n, int m) {
        if (m == 0) {
            return 1;
        }
        if (n == 1) {
            return 2;
        }
        if (n == 2 && m == 1) {
            return 3;
        }
        if (n == 2) {
            return 4;
        }
        if (m == 1) {
            return 4;
        }
        return m == 2 ? 7 : 8;
    }
}
