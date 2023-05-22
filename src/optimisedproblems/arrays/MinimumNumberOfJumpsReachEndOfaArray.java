package optimisedproblems.arrays;

public class MinimumNumberOfJumpsReachEndOfaArray {
    public static int minJumps(int[] arr) {
        int n = arr.length;
        if (n <= 1) {
            return 0; // No jumps required if the array has 0 or 1 element
        }
        int maxReach = arr[0]; // Maximum index that can be reached
        int steps = arr[0]; // Remaining steps in the current jump
        int jumps = 1; // Number of jumps

        for (int i = 1; i < n - 1; i++) {
            // Update the maximum index that can be reached
            maxReach = Math.max(maxReach, i + arr[i]);
            steps--; // Decrement the remaining steps
            if (steps == 0) {
                jumps++; // Perform a jump
                steps = maxReach - i; // Update the remaining steps
            }
        }
        return jumps; // Return the number of jumps
    }

    public static void main(String[] args) {
        // Example usage
        int[] arr = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
        int minJumps = minJumps(arr);
        System.out.println("Minimum number of jumps: " + minJumps);
    }
}
