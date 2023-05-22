package optimisedproblems.strings;

// we can use manchester algo with O(1) T.C
// also can use two pointer approach.  O(n2)
public class LongestPallendromicString {

    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i); // Check for odd length palindromes
            int len2 = expandAroundCenter(s, i, i + 1); // Check for even length palindromes
            int maxLength = Math.max(len1, len2);
            if (maxLength > end - start) {
                start = i - (maxLength - 1) / 2;
                end = i + maxLength / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    private static int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        // Return the length of the palindrome (right - left - 1)
        return right - left - 1;
    }

    public static void main(String[] args) {
        String input = "babad";
        String longestPalindromicSubstring = longestPalindrome(input);
        System.out.println("Longest palindromic substring: " + longestPalindromicSubstring);
    }
}