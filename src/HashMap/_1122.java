package HashMap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author YourFantasy
 * @date 2019/9/21 1:51 下午
 * @description: 数组的相对排序
 */
public class _1122 {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr1.length; i++) {
            if (!map.containsKey(arr1[i])) {
                map.put(arr1[i], 1);
            } else {
                map.put(arr1[i], map.get(arr1[i]) + 1);
            }
        }
        int[] res = new int[arr1.length];
        int len = 0;
        for (int i = 0; i < arr2.length; i++) {
            int l = map.get(arr2[i]);
            for (int j = len; j < len + l; j++) {
                res[j] = arr2[i];
            }
            map.remove(arr2[i]);
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
