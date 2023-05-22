package ArraysAndStrings;
/**
 * Method to compress the string
 * eg :- aabcccccaaa  become a2b1c5a3.
 * using stringBuilder will be useful as while concatenating the string will create multiple copy.
 * @author Anand
 *
 */
public class StringCompression {
    public static String compress(String str) {
        StringBuilder compressed = new StringBuilder();
        int countConsecutive = 0;
        for (int i = 0; i < str.length(); i++) {
            countConsecutive++;      
            System.out.println(i + 1 >= str.length());
            /* If next character is different than current, append this char to result.*/
            //if i+1 is greater than or next element is not eqals to same then add the count consecutive. 
            if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
                compressed.append(str.charAt(i));
                compressed.append(countConsecutive);
                countConsecutive = 0;
            }
        }
        return compressed.length() < str.length() ? compressed.toString() : str;
    }
    
    public static void main(String[] args) {
        String str = "aaabccc";
        System.out.println(compress(str));
    }
}
