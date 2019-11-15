package Two_Pointers;

import org.junit.Test;

public class _76 {
    @Test
    public void test() {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow(s, t));
    }

    public String minWindow(String s, String t) {
        if (t.length() > s.length()) {
            return "";
        }
        // 记录t中各个字符出现次数
        int[] tCount = new int['z' - 'A' + 1];

        for (int i = 0; i < t.length(); i++) {
            tCount[t.charAt(i) - 'A']++;
        }
        // 记录t中独一无二字符的个数
        int size = 0;
        for (int i = 0; i < tCount.length; i++) {
            if (tCount[i] != 0) {
                size++;
            }
        }
        int[] temp = new int['z' - 'A' + 1];
        // left:符合条件子串左边索引；right：符合条件子串右边索引；len：符合条件子串长度
        int left = 0, right = -1, len = s.length() + 1;
        // 工作指针
        int i = 0, j = 0;
        // 记录s中满足t中字符个数要求的字符个数
        int cnt = 0;
        while (j < s.length()) {
            int index = s.charAt(j) - 'A';
            temp[index]++;
            if (tCount[index] != 0 && temp[index] == tCount[index]) {
                cnt++;
            }
            // 当str=s.substring(i,j+1)满足t要求的时候，尝试缩小str范围，看是否依然满足
            while (i <= j && cnt == size) {
                index = s.charAt(i) - 'A';
                if (j - i + 1 < len) {
                    len = j - i + 1;
                    left = i;
                    right = j;
                }
                // 尝试i右移，i右移一位，相应i处的字符串个数应该被去掉
                temp[index]--;
                if (tCount[index] != 0 && temp[index] < tCount[index]) {
                    cnt--;
                }
                i++;
            }
            //  str=str=s.substring(i,j+1)不满足要求，此时继续向右寻找
            j++;
        }
        return len == s.length() + 1 ? "" : s.substring(left, right + 1);
    }
}
