package String;

class _942 {
    public int[] diStringMatch(String S) {
        int len = S.length();
        int m = 0, n = len;
        int[] result = new int[len + 1];
        for (int i = 0; i < len; i++) {
            if (S.charAt(i) == 'I') {
                result[i] = m++;
            } else {
                result[i] = n--;
            }

        }
        result[len] = m;
        return result;
    }
}
