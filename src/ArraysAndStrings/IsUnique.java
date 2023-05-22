package ArraysAndStrings;

/**
 * Write a method that check if a string has all the unique character. without using additional data structure Ex :
 * anand -- false sonali -- true Approach 1. create a array of boolean for every possible string character if string is
 * Ascii use 128 else if it is extended use 256. traverse the whole string and check the value if found if charset then
 * return true else return false. t.c == O(n).
 * 
 * @author Anand
 *
 *         Approach 2.
 *
 */
public class IsUnique {
    // To do using the Bit Vector.
    // use the first approach...
    private static boolean IsUniqueTrue(String str) {
        // check if string length is more than Ascii value, else return false;
        if (str.length() > 128)
            return false;
        boolean[] char_Set = new boolean[128];
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i);
            if (char_Set[val]) { // checking if value is already there i.e true then return false.
                return false;
            }
            char_Set[val] = true; // else case if value is not found then it will be true.
        }
        return true;

    }

    public static void main(String[] args) {
        String str = "anand";
        String str2 = "sonali";
        boolean istrue = IsUniqueTrue(str);
        System.out.println(istrue);
        boolean isTrue2 = IsUniqueTrue(str2);
        System.out.println("istrue for 2nd string" + isTrue2);
    }

}
