package Binary_Search;

class _374 {

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

    private int guess(int n) {
        int target = 20;
        return Integer.compare(target, n);
    }
}
