package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class _1243 {
    public List<Integer> transformArray(int[] arr) {
        List<Integer> res = new ArrayList<>();
        int len = arr.length;
        if (len <= 2) {
            for (int value : arr) {
                res.add(value);
            }
            return res;
        }
        for (int value : arr) {
            res.add(value);
        }
        while (true) {
            boolean flag = false;
            for (int i = 1; i < len - 1; i++) {
                if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                    res.set(i, arr[i] - 1);
                    flag = true;
                } else if (arr[i] < arr[i - 1] && arr[i] < arr[i + 1]) {
                    res.set(i, arr[i] + 1);
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
            for (int i = 1; i < len - 1; i++) {
                arr[i] = res.get(i);
            }
        }
        return res;
    }
}
