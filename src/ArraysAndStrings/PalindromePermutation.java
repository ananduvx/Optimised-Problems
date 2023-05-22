package ArraysAndStrings;
/**
 * method to check permutation of palindrome. 
 * @author Anand
 * need to check the total counts of the characters.
 * no more than one character has an odd count.
 * we will use hash table to check how many times it each character appears.
 *
 */
public class PalindromePermutation {
    private static boolean isPermutationOfPallindrome(String str) {
        int countOdd = 0;
        //create an array initially have value as 0.
        int table[] = new int[Character.getNumericValue('z') - Character.getNumericValue('a')+1];
        for(char c : str.toCharArray()) {
            int x = getCharNumber(c);
        if(x != -1) {
            //increment the value if got the value at that point. 
         table[x]++;   
        if(table[x] %2 == 1) {
            //if that value is odd increment it. 
            countOdd++;
        }
        else {
        // if the incremented value is not not odd then reduce it. 
            countOdd--;
        }
        }
        }
        return countOdd <= 1;
        
    }
    public static int getCharNumber(Character c) {
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
        
        int val = Character.getNumericValue(c);
        if (a <= val && val <= z) {
            return val - a;
        }
        return -1;
    }
    public static void main(String[] args) {
        boolean istrue = isPermutationOfPallindrome("taco cat");
        System.out.println(istrue);
    }

}
