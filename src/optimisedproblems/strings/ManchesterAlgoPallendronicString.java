package optimisedproblems.strings;
/**
 * Finding the longest pallendrome using manchester Algorithms
 * @author Anand
 *
 */
public class ManchesterAlgoPallendronicString {
    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }

        // Preprocess the input string to insert special characters between characters
        StringBuilder sb = new StringBuilder();
        sb.append("#");
        for (char c : s.toCharArray()) {
            sb.append(c);
            sb.append("#");
        }
        String modifiedString = sb.toString();

        int n = modifiedString.length();
        int[] palindromeLengths = new int[n]; // Array to store the lengths of palindromes centered at each position
        int center = 0; // Center position of the current palindrome
        int rightBoundary = 0; // Right boundary of the current palindrome

        int maxPalindromeLength = 0; // Length of the longest palindrome found
        int maxPalindromeCenter = 0; // Center position of the longest palindrome found

        for (int i = 1; i < n - 1; i++) {
            int mirror = 2 * center - i; // Mirror position of i based on the current palindrome center

            // Check if the current position i is within the right boundary of the current palindrome
            if (i < rightBoundary) {
                palindromeLengths[i] = Math.min(rightBoundary - i, palindromeLengths[mirror]);
            }

            // Expand the palindrome at the current position i
            while (modifiedString.charAt(i + (1 + palindromeLengths[i])) == modifiedString.charAt(i - (1 + palindromeLengths[i]))) {
                palindromeLengths[i]++;
            }

            // Check if the expanded palindrome extends beyond the current right boundary
            if (i + palindromeLengths[i] > rightBoundary) {
                center = i;
                rightBoundary = i + palindromeLengths[i];

                // Check if the current palindrome is longer than the previously found longest palindrome
                if (palindromeLengths[i] > maxPalindromeLength) {
                    maxPalindromeLength = palindromeLengths[i];
                    maxPalindromeCenter = i;
                }
            }
        }

        // Extract the longest palindromic substring from the modified string
        int start = (maxPalindromeCenter - maxPalindromeLength) / 2;
        int end = start + maxPalindromeLength;
        return s.substring(start, end);
    }

    public static void main(String[] args) {
        String input = "babad";
        String longestPalindromicSubstring = longestPalindrome(input);
        System.out.println("Longest palindromic substring: " + longestPalindromicSubstring);
    }
}