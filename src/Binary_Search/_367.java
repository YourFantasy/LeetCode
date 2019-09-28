package Binary_Search;

import org.junit.Test;

public class _367 {
    @Test
    public void Test(){
        int a=Integer.MAX_VALUE;
        System.out.println(a);
        System.out.println(Long.MAX_VALUE);
        System.out.println((long)808201*(long)808201);
        System.out.println(isPerfectSquare(808201));
    }
    private boolean isPerfectSquare(int num) {
        if (num == 0 || num == 1) {
            return true;
        }
        long i = 0, j = num / 2;
        while (i <= j) {
            long mid = (i + j) / 2;
            long temp = mid * mid;
            if (temp == num) {
                return true;
            } else if (temp > num) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        return false;
    }
}