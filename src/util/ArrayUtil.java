package util;

import java.util.Random;

/**
 * @author : guochengsen@outlook.com
 * @date :
 */
public class ArrayUtil {

    private static final Random RANDOM = new Random();

    public static void merge(int[] arr, int l, int m, int r) {
        int[] aux = new int[r - l + 1];
        for (int i = l; i <= r; i++) {
            aux[i - l] = arr[i];
        }
        int i = l, j = m + 1;
        for (int k = l; k <= r; k++) {
            if (i > m) {
                arr[k] = aux[j - l];
                j++;
            } else if (j > r) {
                arr[k] = aux[i - l];
                i++;
            } else if (aux[i - l] < aux[j - l]) {
                arr[k] = aux[i - l];
                i++;
            } else {
                arr[k] = aux[j - l];
                j++;
            }
        }
    }

    public static int[] merge(int[] arr1, int[] arr2) {
        int[] res = new int[arr1.length + arr2.length];
        int i = 0, j = 0, k = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] >= arr2[j]) {
                res[k] = arr2[j++];
            } else {
                res[k] = arr1[i++];
            }
            k++;
        }
        while (i < arr1.length) {
            res[k++] = arr1[i++];
        }
        while (j < arr2.length) {
            res[k++] = arr2[j++];
        }
        return res;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void check(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (i + 1 <= arr.length - 1) {
                if (arr[i + 1] < arr[i]) {
                    System.out.println("array is not sorted.");
                    return;
                }
            }
        }
        System.out.println("array is sorted.");
    }

    public static int[] produce(int length, int range) {
        RANDOM.setSeed(System.currentTimeMillis());
        int[] arr = new int[length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = RANDOM.nextInt(range);
        }
        return arr;
    }

    public static void print(int[] arr) {
        StringBuilder sb = new StringBuilder(arr.length);
        sb.append('[');
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i != arr.length - 1) {
                sb.append(", ");
            }
        }
        sb.append(']');
        System.out.println(sb.toString());
    }

}
