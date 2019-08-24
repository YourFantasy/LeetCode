package Math;

public class _67 {
    public String addBinary(String a, String b) {
        int len1 = a.length(), len2 = b.length();
        int len = Math.min(len1, len2);
        int length = len;
        int A, B;
        int temp = 0;
        String result = "";
        int index = 1;
        while (len > 0) {
            A = a.charAt(len1 - index) - '0';
            B = b.charAt(len2 - index) - '0';
            result = (A + B + temp) % 2 + result;
            temp = (temp + A + B) / 2;
            len--;
            index++;
        }
        int i = len1 - length, j = len2 - length;
        while (i > 0) {
            A = a.charAt(i - 1) - '0';
            result = (A + temp) % 2 + result;
            temp = (A + temp) / 2;
            i--;
        }
        while (j > 0) {
            B = b.charAt(j - 1) - '0';
            result = (B + temp) % 2 + result;
            temp = (B + temp) / 2;
            j--;
        }
        if (temp > 0) {
            result = temp + result;
        }
        return result;
    }
}
