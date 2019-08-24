package String;

import java.util.ArrayList;
import java.util.List;

public class _1002 {
    public List<String> commonChars(String[] A) {
        int n = A.length;
        List<String> res = new ArrayList<>();
        int[][] count = new int[n][26];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < A[i].length(); j++) {
                int index = A[i].charAt(j) - 'a';
                count[i][index]++;
            }
        }
        for (int i = 0; i < 26; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                if (count[j][i] == 0) {
                    min = 0;
                    break;
                }
                if (count[j][i] < min) {
                    min = count[j][i];
                }
            }
            if (min > 0) {
                char ch = (char) ('a' + i);
                for (int k = 0; k < min; k++) {
                    res.add("" + ch);
                }
            }
        }
        return res;
    }
}
