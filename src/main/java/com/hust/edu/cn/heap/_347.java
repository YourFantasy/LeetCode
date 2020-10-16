package com.hust.edu.cn.heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class _347 {
    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int num : nums) {
            cnt.put(num, cnt.getOrDefault(num, 0) + 1);
        }
        Queue<int[]> queue = new PriorityQueue<>(((o1, o2) -> o2[1] - o1[1]));
        for (int key : cnt.keySet()) {
            queue.add(new int[]{key, cnt.get(key)});
        }
        for (int i = 0; i < k; i++) {
            res[i] = queue.poll()[0];
        }
        return res;
    }

}
