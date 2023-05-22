package optimisedproblems.strings;

public class HirschbergAlgo {
    public static String longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        if (m == 0 || n == 0) {
            return "";
        }

        if (m == 1) {
            if (text2.contains(text1)) {
                return text1;
            } else {
                return "";
            }
        }

        int mid1 = m / 2;

        // Compute LCS lengths for the first half of text1 and text2
        int[] lcs1 = computeLCSLengths(text1.substring(0, mid1), text2);

        // Compute LCS lengths for the second half of text1 and text2
        int[] lcs2 = computeLCSLengths(new StringBuilder(text1.substring(mid1)).reverse().toString(),
                new StringBuilder(text2).reverse().toString());

        int maxLen = 0;
        int splitPoint = -1;

        // Find the split point that maximizes the sum of LCS lengths
        for (int i = 0; i <= n; i++) {
            int len = lcs1[i] + lcs2[n - i];
            if (len > maxLen) {
                maxLen = len;
                splitPoint = i;
            }
        }

        if (splitPoint == -1) {
            return "";
        }

        // Recurse on the two halves of text1 and text2
        String lcsLeft = longestCommonSubsequence(text1.substring(0, mid1), text2.substring(0, splitPoint));
        String lcsRight = longestCommonSubsequence(text1.substring(mid1), text2.substring(splitPoint));

        // Concatenate the two LCS strings
        return lcsLeft + lcsRight;
    }

    private static int[] computeLCSLengths(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        int[] dp = new int[n + 1];
        int[] prev;

        for (int i = 1; i <= m; i++) {
            prev = dp.clone();

            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[j] = prev[j - 1] + 1;
                } else {
                    dp[j] = Math.max(dp[j - 1], dp[j]);
                }
            }
        }

        return dp;
    }

    public static void main(String[] args) {
        String text1 = "abcdef";
        String text2 = "acef";
        String lcs = longestCommonSubsequence(text1, text2);
        System.out.println("Longest Common Subsequence: " + lcs);
    }
}