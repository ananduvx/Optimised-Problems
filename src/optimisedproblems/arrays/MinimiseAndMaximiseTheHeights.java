package optimisedproblems.arrays;

import java.util.Arrays;

/**
 * 
 * @author Anand
 *
 */
public class MinimiseAndMaximiseTheHeights {
    public static int minimizeMaxDifference(int[] heights) {
        // Sort the heights in ascending order
        Arrays.sort(heights);
        int n = heights.length;
        int maxDiff = 0;
        // Calculate the difference between adjacent heights
        for (int i = 0; i < n - 1; i++) {
            maxDiff = Math.max(maxDiff, heights[i + 1] - heights[i]);
        }
        return maxDiff;
    }
    public static void main(String[] args) {
        int[] heights = { 5, 10, 15, 20, 25 };
        int minMaxDiff = minimizeMaxDifference(heights);
        System.out.println("Minimum maximum difference: " + minMaxDiff);
    }
}