package optimisedproblems.strings;

public class LongestRecurringSubsequence {
    public static String longestRecurringSubsequence(String str) {
        int n = str.length();
        int[][] dp = new int[n + 1][n + 1];

        // Calculate the lengths of LRS for all prefixes of the string
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (str.charAt(i - 1) == str.charAt(j - 1) && i != j) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // Reconstruct the LRS string from dp table
        StringBuilder lrs = new StringBuilder();
        int i = n, j = n;
        while (i > 0 && j > 0) {
            if (dp[i][j] == dp[i - 1][j - 1] + 1) {
                lrs.insert(0, str.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i][j] == dp[i - 1][j]) {
                i--;
            } else {
                j--;
            }
        }

        return lrs.toString();
    }

    public static void main(String[] args) {
        String input = "aabcaabdaab";
        String lrs = longestRecurringSubsequence(input);
        System.out.println("Longest Recurring Subsequence: " + lrs);
    }
}