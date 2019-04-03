package Binary_Search;

public class _852 {
    public int peakIndexInMountainArray(int[] A) {
        int index = 1;
        int max = A[1];
        for (int i = 1; i < A.length - 1; i++) {
            if (A[i] > max) {
                max = A[i];
                index = i;
            }
        }
        return index;
    }
}
