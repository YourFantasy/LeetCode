package com.hust.edu.cn.heap;

import java.util.PriorityQueue;
import java.util.Queue;

public class _215 {
    /**
     * 暴力法，速度慢
     *
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest0(int[] nums, int k) {
        for (int i = 0; i < k; i++) {
            int max = nums[i];
            int index = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (max < nums[j]) {
                    max = nums[j];
                    index = j;
                }
            }
            int temp = nums[index];
            nums[index] = nums[i];
            nums[i] = temp;
        }
        return nums[k - 1];
    }

    /**
     * 使用快排
     *
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest1(int[] nums, int k) {
        return QuickSort(nums, k, 0, nums.length - 1);
    }

    public int QuickSort(int[] nums, int k, int left, int right) {
        int i = left, j = right, flag = nums[i];
        while (i < j) {
            while (i < j && nums[j] >= flag) {
                j--;
            }
            if (i < j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
            }
            while (i < j && nums[i] < flag) {
                i++;
            }
            if (i < j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j--;
            }
        }
        if (k == nums.length - j) {
            return nums[j];
        } else if (k > nums.length - j) {
            return QuickSort(nums, k, left, j - 1);
        }
        return QuickSort(nums, k, j + 1, right);
    }

    /**
     * 使用堆排序，推荐
     *
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest2(int[] nums, int k) {
        sort(nums, nums.length, k);
        return nums[nums.length - k];
    }

    public void adjust(int[] nums, int size, int index) {
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        int maxIndex = index;
        if (left < size && nums[left] > nums[maxIndex]) {
            maxIndex = left;
        }
        if (right < size && nums[right] > nums[maxIndex]) {
            maxIndex = right;
        }
        if (maxIndex != index) {
            int temp = nums[index];
            nums[index] = nums[maxIndex];
            nums[maxIndex] = temp;
            adjust(nums, size, maxIndex);
        }
    }

    public void sort(int[] nums, int size, int k) {
        // 构建大顶堆，初始化大顶堆
        for (int i = size / 2 - 1; i >= 0; i--) {
            adjust(nums, size, i);
        }
        for (int i = size - 1; i >= size - k; i--) {
            // 每次将大顶堆中最大的元素(arr[0])与剩余数组最后一个元素进行交换，因为堆排序也是一种选择排序，每次选择剩余数组中最大元素放在剩余数组的最尾部
            int temp = nums[0];
            nums[0] = nums[i];
            nums[i] = temp;
            // 调整剩余的部分，始终保持剩余数组为一个大顶堆
            adjust(nums, i, 0);
        }
    }

    public int findKthLargest3(int[] nums, int k) {
        Queue<Integer> queue = new PriorityQueue<>();
        for (int a : nums) {
            queue.offer(a);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        return queue.peek();
    }
}
