package Math;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class _13 {
    @Test
    public void test() {
        int a = romanToInt("MCMXCIV");
        System.out.println(a);
    }

    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int res = 0, temp;
        int i = 0;
        while (i < s.length() - 1) {
            if (s.charAt(i) == 'I' && s.charAt(i + 1) == 'V') {
                temp = 4;
                i += 2;
                res += temp;
                continue;
            }
            if (s.charAt(i) == 'I' && s.charAt(i + 1) == 'X') {
                temp = 9;
                i += 2;
                res += temp;
                continue;
            }
            if (s.charAt(i) == 'X' && s.charAt(i + 1) == 'L') {
                temp = 40;
                i += 2;
                res += temp;
                continue;
            }
            if (s.charAt(i) == 'X' && s.charAt(i + 1) == 'C') {
                temp = 90;
                i += 2;
                res += temp;
                continue;
            }
            if (s.charAt(i) == 'C' && s.charAt(i + 1) == 'D') {
                temp = 400;
                i += 2;
                res += temp;
                continue;
            }
            if (s.charAt(i) == 'C' && s.charAt(i + 1) == 'M') {
                temp = 900;
                i += 2;
                res += temp;
                continue;
            } else {
                temp = map.get(s.charAt(i));
                i += 1;
                res += temp;
                continue;
            }
        }
        if (i == s.length() - 1) {
            res += map.get(s.charAt(i));
        }
        return res;
    }
}
