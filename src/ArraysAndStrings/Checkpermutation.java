package ArraysAndStrings;
/**
 * class to check if string is permutation of other string. 
 * @author Anand
 * Approach 1. sort the one array using array.sort() and check if both are equals. 
 * approach 2.  check if two string have same character count. 
 */


public class Checkpermutation {
    private  static boolean isPermutation(String s1, String s2) {
        if(s1.length() != s2.length()) return false;
        int [] letters = new int[128];     //array to store the char.
        char[] s_array = s1.toCharArray();  // crating string into char array. 
        for(char c:s_array ) {             // loop to store the value into letter array.
            letters[c]++;
        }
        for(int i= 0; i< s2.length(); i++) {
            int c = s2.charAt(i);
            letters[c]--;
            if(letters[c]<0) return false;
        }
        
        return true; 
    }
    public static void main(String args[]) {
        boolean ispermutation = isPermutation("anand","dnanaa");
        System.out.println(ispermutation);
    }
}
