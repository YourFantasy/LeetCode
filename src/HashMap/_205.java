package HashMap;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class _205 {
    @Test
    public void test() {
        System.out.println(isIsomorphic("abb", "baa"));
    }

    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                if (map.containsValue(t.charAt(i)))
                    return false;
                map.put(s.charAt(i), t.charAt(i));
            } else {
                if (map.get(s.charAt(i)) != t.charAt(i))
                    return false;
            }
        }
        return true;
    }
}
