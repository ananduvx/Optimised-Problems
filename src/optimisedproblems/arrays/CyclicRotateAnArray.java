package optimisedproblems.arrays;
/**
 * Cyclically rotate an array. 
 * @author Anand
 *
 */
public class CyclicRotateAnArray {
    public static void cyclicallyRotate(int[] arr) {
        if (arr.length <= 1) {
            return; // No rotation needed for arrays of size 0 or 1
        }

        int temp = arr[arr.length - 1]; // Store the last element in a temporary variable

        for (int i = arr.length - 1; i > 0; i--) {
            arr[i] = arr[i - 1]; // Shift elements one position to the right
        }

        arr[0] = temp; // Place the temporary variable (last element) at the beginning
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };
        cyclicallyRotate(arr);

        System.out.println("Cyclically Rotated Array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
