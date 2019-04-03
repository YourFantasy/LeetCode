package Greedy;

import java.util.Arrays;

public class _455 {
    public int findContentChildren(int[] g, int[] s) {
        int cnt = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int index = 0;
        for (int i = 0; i < g.length; i++) {
            for (int j = index; j < s.length; j++) {
                if (g[i] <= s[j]) {
                    cnt++;
                    index = j + 1;
                    break;
                }
            }
        }
        return cnt;
    }
}
