package Sort;

import java.util.Arrays;

public class HeapSort {
    public static void adjust(int[] arr, int len, int index) {
        int left = 2 * index + 1;
        int right = 2 * index + 2;

        int maxIndex = index;
        if (left < len && arr[left] > arr[maxIndex]) {
            maxIndex = index;
        }
        if (right < len && arr[right] > arr[maxIndex]) {
            maxIndex = right;
        }
        if (maxIndex != index) {
            int temp = arr[index];
            arr[index] = arr[maxIndex];
            arr[maxIndex] = temp;
            adjust(arr, len, maxIndex);
        }
    }

    public static void sort(int[] arr, int size) {
        for (int i = size / 2 - 1; i >= 0; i--) {
            adjust(arr, size, 1);
        }
        for (int i = size - 1; i >= 1; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            adjust(arr, i, 0);
        }
    }

    public static void main() {
        int n = 20;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = (int) (Math.random() * n - n / 2);
        }
        System.out.println(Arrays.toString(arr));
        sort(arr, n);
        System.out.println(Arrays.toString(arr));
    }
}