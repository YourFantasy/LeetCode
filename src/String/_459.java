package String;

import org.junit.Test;

/**
 * @author YourFantasy
 * @date 2019/9/25 5:30 下午
 * @description: 重复的子字符串
 */
public class _459 {
    @Test
    public void test() {
        String s = "abaababaab";
        boolean res = repeatedSubstringPattern(s);
        System.out.println(res);
    }

    private boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        for (int l = 1; l < len; l++) {
            if (len % l != 0) {
                continue;
            }
            String base = s.substring(0, l);
            boolean flag = true;
            for (int i = 0; i <= len-l; i += l) {
                if (!base.equals(s.substring(i, i + l))) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return true;
            }
        }
        return false;
    }
}
