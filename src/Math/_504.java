package Math;

public class _504 {
    public String convertToBase7(int num) {
        if (num == 0)
            return "0";
        boolean flag = true;
        if (num < 0) {
            num *= -1;
            flag = false;
        }
        String res = "";
        while (num != 0) {
            res = num % 7 + res;
            num /= 7;
        }
        return flag ? res : "-" + res;
    }
}
