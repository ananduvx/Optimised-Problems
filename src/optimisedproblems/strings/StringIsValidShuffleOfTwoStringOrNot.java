package optimisedproblems.strings;
//Using Two pointer approach 
public class StringIsValidShuffleOfTwoStringOrNot {
    public static boolean isValidShuffle(String str, String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        int len = str.length();
//Base condition
        if (len != len1 + len2) {
            return false;
        }
        int i = 0; // Index for str1
        int j = 0; // Index for str2

        // Iterate through each character of the given string
        for (int k = 0; k < len; k++) {
            // If there are still characters remaining in str1 and the current character
            // matches with the next character in str1, move to the next character in str1
            if (i < len1 && str.charAt(k) == str1.charAt(i)) {
                i++;
            }
            // If there are still characters remaining in str2 and the current character
            // matches with the next character in str2, move to the next character in str2
            else if (j < len2 && str.charAt(k) == str2.charAt(j)) {
                j++;
            }
            // If neither str1 nor str2 matches the current character, the given string
            // is not a valid shuffle
            else {
                return false;
            }
        }

        // If all characters of the given string have been checked and there are no
        // remaining characters in str1 and str2, it is a valid shuffle
        return (i == len1 && j == len2);
    }

    public static void main(String[] args) {
        String str = "abcxyz";
        String str1 = "abc";
        String str2 = "xyz";

        if (isValidShuffle(str, str1, str2)) {
            System.out.println(str + " is a valid shuffle of " + str1 + " and " + str2);
        } else {
            System.out.println(str + " is not a valid shuffle of " + str1 + " and " + str2);
        }
    }
}