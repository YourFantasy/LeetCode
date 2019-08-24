package HashMap;

import org.junit.Test;

import java.util.*;

public class _49 {
    @Test
    public void test() {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams1(strs));
        System.out.println(groupAnagrams2(strs));
    }

    public List<List<String>> groupAnagrams1(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<Integer>> map = new HashMap<>();
        String[] s = new String[strs.length];
        for (int i = 0; i < strs.length; i++) {
            char[] ch = strs[i].toCharArray();
            Arrays.sort(ch);
            s[i] = new String(ch);
        }
        for (int i = 0; i < s.length; i++) {
            List<Integer> temp = new ArrayList<>();
            if (map.containsKey(s[i])) {
                temp = map.get(s[i]);
                temp.add(i);
                map.put(s[i], temp);
            } else {
                temp.add(i);
                map.put(s[i], temp);
            }
        }
        for (Map.Entry<String, List<Integer>> entry : map.entrySet()) {
            List<Integer> list = entry.getValue();
            List<String> temp = new ArrayList<>();
            for (int index : list) {
                temp.add(strs[index]);
            }
            res.add(temp);
        }
        return res;
    }

    public List<List<String>> groupAnagrams2(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] ch = strs[i].toCharArray();
            Arrays.sort(ch);
            String str = String.valueOf(ch);
            if (!map.containsKey(str)) {
                map.put(str, new ArrayList<>());
            }
            map.get(str).add(strs[i]);
        }
        return new ArrayList<>(map.values());
    }
}
