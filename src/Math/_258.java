package Math;

class _258 {
    public int addDigits(int num) {
        while (num >= 10) {
            int temp = num % 10;
            num = num / 10 + temp;
        }
        return num;
    }
}
