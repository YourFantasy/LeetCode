package String;

public class _43 {
    public String multiply(String s1, String s2) {
        String res = "";
        if ("0".equals(s1) || "0".equals(s2)) {
            return "0";
        }
        int len1 = s1.length();
        int len2 = s2.length();
        int cnt = 0;
        for (int i = len1 - 1; i >= 0; i--) {
            String temp = "";
            int a = 0;
            for (int j = len2 - 1; j >= 0; j--) {
                int m = Integer.parseInt("" + s1.charAt(i));
                int n = Integer.parseInt("" + s2.charAt(j));
                temp = (m * n + a) % 10 + temp;
                a = (m * n + a) / 10;
            }
            if (a > 0) {
                temp = a + temp;
            }
            //System.out.print(temp + ",");
            res = sum(res, temp, cnt++);
            //System.out.println();
            // System.out.print(res + "  ");
        }
        return res;
    }

    public static String sum(String s1, String s2, int cnt) {
        String res = "";
        for (int i = s1.length() - cnt; i < s1.length(); i++) {
            res = res + s1.charAt(i);
        }
        int a = 0;
        int i = s1.length() - cnt - 1, j = s2.length() - 1;
        while (i >= 0 && j >= 0) {
            int m = Integer.parseInt("" + s1.charAt(i));
            int n = Integer.parseInt("" + s2.charAt(j));
            res = (m + n + a) % 10 + res;
            a = (m + n + a) / 10;
            i--;
            j--;
        }
        while (i >= 0) {
            int m = Integer.parseInt("" + s1.charAt(i));
            res = (m + a) % 10 + res;
            a = (m + a) / 10;
            i--;

        }
        while (j >= 0) {
            int n = Integer.parseInt("" + s2.charAt(j));
            res = (n + a) % 10 + res;
            a = (n + a) / 10;
            j--;

        }
        if (a > 0) {
            res = a + res;
        }
        return res;
    }
}
