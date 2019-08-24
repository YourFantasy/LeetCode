package HashMap;

public class _771 {
    public int numJewelsInStones(String J, String S) {
        int cnt = 0;
        for (int i = 0; i < J.length(); i++) {
            for (int j = 0; j < S.length(); j++) {
                if (J.charAt(i) == S.charAt(j)) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
