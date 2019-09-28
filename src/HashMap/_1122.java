package HashMap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author YourFantasy
 * @date 2019/9/21 1:51 下午
 * @description: 数组的相对排序
 */
class _1122 {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int item : arr1) {
            if (!map.containsKey(item)) {
                map.put(item, 1);
            } else {
                map.put(item, map.get(item) + 1);
            }
        }
        int[] res = new int[arr1.length];
        int len = 0;
        for (int value : arr2) {
            int l = map.get(value);
            for (int j = len; j < len + l; j++) {
                res[j] = value;
            }
            map.remove(value);
            len += l;
        }
        int size = map.size();
        int[] temp = new int[size];
        int index = 0;
        for (Integer key : map.keySet()) {
            temp[index++] = key;
        }
        Arrays.sort(temp);
        for (int i = 0; i < size; i++) {
            int l = map.get(temp[i]);
            for (int j = len; j < l + len; j++) {
                res[j] = temp[i];
            }
            len += l;
        }
        return res;
    }
}
