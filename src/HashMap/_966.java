package HashMap;

import java.util.HashMap;
import java.util.Map;

public class _966 {
    public String[] spellchecker(String[] wordlist, String[] queries) {

        int len = queries.length;
        Map<Character, Integer> map = new HashMap<>();
        map.put('a', 1);
        map.put('e', 2);
        map.put('i', 3);
        map.put('o', 4);
        map.put('u', 5);
        Map<String, String> map1 = new HashMap<>();
        Map<String, String> map2 = new HashMap<>();
        for (String word : wordlist) {
            map1.put(word, word);
            if (!map2.containsKey(word.toLowerCase())) {
                map2.put(word.toLowerCase(), word);
            }
            if (!map2.containsKey(dealVowel(word, map))) {
                map2.put(dealVowel(word, map), word);
            }
        }
        for (int i = 0; i < len; i++) {
            if (map1.containsKey(queries[i])) {
                continue;
            }
            if (map2.containsKey(queries[i].toLowerCase())) {
                queries[i] = map2.get(queries[i].toLowerCase());
                continue;
            }
            if (map2.containsKey(dealVowel(queries[i], map))) {
                queries[i] = map2.get(dealVowel(queries[i], map));
                continue;
            }
            queries[i] = "";
        }
        return queries;
    }

    public String dealVowel(String s, Map<Character, Integer> map) {
        char[] temp = s.toLowerCase().toCharArray();
        for (int i = 0; i < temp.length; i++) {
            if (map.containsKey(temp[i])) {
                temp[i] = '*';
            }
        }
        return String.valueOf(temp);
    }
}
