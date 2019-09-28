package Math;

/**
 * @author YourFantasy
 * @date 2019-08-27 19:45
 * @description: 判读回文素数
 */
class _866 {
    public int primePalindrome(int N) {
        while (true) {
            if (isPrime(N) && isPalindrome(Integer.toString(N))) {
                return N;
            }
            int len = Integer.toString(N).length();
            /**
             * 设回文数n，如果n的形式位a1-a2-a3..an-an-..a3-a2-a1的形式即n的位数为偶数时候，可以用数学归纳法证明n可以被11整除
             */
            if (N > 10 && len % 2 == 0) {
                N = (int) Math.pow(10, len + 1);
            } else {
                N++;
            }
        }
    }

    private boolean isPrime(int a) {
        if (a < 2) {
            return false;
        }
        for (int i = 2; i <= (int) Math.sqrt(a); i++) {
            if (a % i == 0) {
                return false;
            }
        }
        return true;
    }

    private boolean isPalindrome(String str) {
        int i = 0, j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
