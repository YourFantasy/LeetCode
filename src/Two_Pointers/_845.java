package Two_Pointers;

public class _845 {
    public int longestMountain(int[] A) {
        int len = A.length;
        if (len < 3) {
            return 0;
        }
        int res = 0;
        for (int i = 1; i < len - 1; i++) {
            int l = i - 1, r = i + 1;
            if (A[l] >= A[i] || A[r] >= A[i]) {
                continue;
            }
            while (l >= 0 && A[l] < A[l + 1]) {
                l--;
            }
            while (r < len && A[r] < A[r - 1]) {
                r++;
            }
            if (l != i - 1 && r != i + 1) {
                res = Math.max(r - l - 1, res);
            }
        }
        return res;
    }
}
