package optimisedproblems.arrays;

import java.util.Random;

public class KthMinAndMax {
    private static Random random = new Random();

    public static int partition(int[] arr, int low, int high) {
        // Randomized pivot selection to avoid worst-case scenarios
        int pivotIndex = random.nextInt(high - low + 1) + low;
        swap(arr, pivotIndex, high);

        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, high);
        return i + 1;
    }

    public static int quickselect(int[] arr, int low, int high, int k) {
        if (low == high) {
            return arr[low];
        }

        int pivotIndex = partition(arr, low, high);

        if (k == pivotIndex) {
            return arr[k];
        } else if (k < pivotIndex) {
            return quickselect(arr, low, pivotIndex - 1, k);
        } else {
            return quickselect(arr, pivotIndex + 1, high, k);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int[] findKthMinMax(int[] arr, int k) {
        int n = arr.length;

        if (k < 1 || k > n) {
            return null;
        }

        int kthMin = quickselect(arr, 0, n - 1, k - 1);
        int kthMax = quickselect(arr, 0, n - 1, n - k);
        return new int[] { kthMin, kthMax };
    }

    public static void main(String[] args) {
        int[] arr = { 9, 2, 5, 1, 7, 3 };
        int k = 3;

        int[] result = findKthMinMax(arr, k);
        System.out.println("Kth Min: " + result[0]);
        System.out.println("Kth Max: " + result[1]);
    }
}