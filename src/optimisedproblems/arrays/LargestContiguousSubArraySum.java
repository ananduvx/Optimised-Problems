package optimisedproblems.arrays;
/**
 * Kadens Algo.
 * @author Anand
 *
 */
public class LargestContiguousSubArraySum {
        public static int findMaxSubarraySum(int[] arr) {
            if (arr.length == 0) {
                return 0; // Empty array case
            }
            int currentSum = arr[0]; // Track the maximum sum found so far
            int bestSum = arr[0]; // Track the maximum sum ending at the current position

            for (int i = 1; i < arr.length; i++) {
                currentSum = Math.max(arr[i], currentSum + arr[i]);
                bestSum = Math.max(currentSum, bestSum);
            }
            return bestSum;
        }

        public static void main(String[] args) {
            int[] arr = { -2, -3, 4, -1, -2, 1, 5, -3 };
            int maxSum = findMaxSubarraySum(arr);
            System.out.println("Largest sum contiguous subarray: " + maxSum);
        }
    }
