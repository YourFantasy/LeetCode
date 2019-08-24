package Binary_Search;

public class _278 {
    public int firstBadVersion(int n) {
        int i = 1, j = n;
        while (i < j) {
            int mid = i + (j - i) / 2;
            if (!isBadVersion(mid)) {
                i = mid + 1;
            } else {
                j = mid;
            }
        }
        return i;
    }

    boolean isBadVersion(int version) {
        return true;
    }
}
