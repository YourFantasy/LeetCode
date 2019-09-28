package String;

class _43 {
    public String multiply(String s1, String s2) {
        String res = "";
        if ("0".equals(s1) || "0".equals(s2)) {
            return "0";
        }
        int len1 = s1.length();
        int len2 = s2.length();
        int cnt = 0;
        for (int i = len1 - 1; i >= 0; i--) {
            StringBuilder temp = new StringBuilder();
            int a = 0;
            for (int j = len2 - 1; j >= 0; j--) {
                int m = Integer.parseInt("" + s1.charAt(i));
                int n = Integer.parseInt("" + s2.charAt(j));
                temp.insert(0, (m * n + a) % 10);
                a = (m * n + a) / 10;
            }
            if (a > 0) {
                temp.insert(0, a);
            }
            //System.out.print(temp + ",");
            res = sum(res, temp.toString(), cnt++);
            //System.out.println();
            // System.out.print(res + "  ");
        }
        return res;
    }

    private static String sum(String s1, String s2, int cnt) {
        StringBuilder res = new StringBuilder();
        for (int i = s1.length() - cnt; i < s1.length(); i++) {
            res.append(s1.charAt(i));
        }
        int a = 0;
        int i = s1.length() - cnt - 1, j = s2.length() - 1;
        while (i >= 0 && j >= 0) {
            int m = Integer.parseInt("" + s1.charAt(i));
            int n = Integer.parseInt("" + s2.charAt(j));
            res.insert(0, (m + n + a) % 10);
            a = (m + n + a) / 10;
            i--;
            j--;
        }
        while (i >= 0) {
            int m = Integer.parseInt("" + s1.charAt(i));
            res.insert(0, (m + a) % 10);
            a = (m + a) / 10;
            i--;

        }
        while (j >= 0) {
            int n = Integer.parseInt("" + s2.charAt(j));
            res.insert(0, (n + a) % 10);
            a = (n + a) / 10;
            j--;

        }
        if (a > 0) {
            res.insert(0, a);
        }
        return res.toString();
    }
}
