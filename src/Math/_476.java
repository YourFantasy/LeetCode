package Math;

public class _476 {
    public int findComplement(int num) {
        int result = 0;
        int pow = 1;
        while (num > 0) {
            int temp = num % 2;
            if (temp == 1)
                temp = 0;
            else
                temp = 1;
            result += pow * temp;
            pow *= 2;
            num /= 2;
        }
        return result;
    }
}
