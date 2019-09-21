package HashMap;

import java.util.HashMap;
import java.util.Map;

/**
 * @author YourFantasy
 * @date 2019/9/21 10:45 上午
 * @description: 最短完整词
 */
public class _748 {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        Map<Character, Integer> map1 = getMap(licensePlate);
        String res = "";
        int maxlen = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            boolean flag = true;
            Map<Character, Integer> map = getMap(words[i]);
            for (Character ch : map1.keySet()) {
                if (!map.containsKey(ch) || map.get(ch) < map1.get(ch)) {
                    flag = false;
                    break;
                }
            }
            if (flag && words[i].length() < maxlen) {
                res = words[i];
                maxlen = words[i].length();
            }
        }
        return res;

    }

    public Map<Character, Integer> getMap(String str) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch >= 'a' && ch <= 'z' || ch >= 'A' && ch <= 'Z') {
                if (ch <= 'Z') {
                    ch += 32;
                }
                if (!map.containsKey(ch)) {
                    map.put(ch, 1);
                } else {
                    map.put(ch, map.get(ch) + 1);
                }
            }
        }
        return map;
    }
}
