package Binary_Search;

public class _374 {
    final int target = 20;

    public int guessNumber(int n) {
        int i = 1, j = n;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (guess(mid) == 0) {
                return mid;
            }
            if (guess(mid) == -1) {
                j = mid - 1;
            }
            if (guess(mid) == 1) {
                i = mid + 1;
            }
        }
        return 0;
    }

    int guess(int n) {
        if (n == target) {
            return 0;
        }
        if (n > target) {
            return -1;
        }
        return 1;
    }
}
