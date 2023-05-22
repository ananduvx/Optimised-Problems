package ArraysAndStrings;
/**
 * class to check if the given string is one edit away or not. 
 * eg:- pale , ple == true
 *      pales , pale == true   // if s2 len> s1 then insert operation 
 *      pale , bale = true   // if string length is same check for only one string replace.
 *      pale, bae == false.
 *       
 *       approch --
 *         edit should be only one.. 
 * @author Anand
 *
 */
public class OneEditAway {

    private static boolean oneEditAway(String first, String second) {
        // check for length if lenght is more than one then return false;
        if(Math.abs(first.length()-second.length())> 1) return false;
        //get the shorter and longer string;
        String s1 = first.length()<second.length()? first: second;   // smaller string
        String s2 = first.length()<second.length()? second: first;  // bigger one string
        int index1 = 0;
        int index2 = 0;
        boolean foundDifference = false;
        //lets start loop
        while(index2<s2.length() && index1<s1.length()) {
            if(s1.charAt(index1) != s2.charAt(index2)) {
                //if this condition is there means first difference found we don't want other one 
                if(foundDifference) return false; // check for found difference in case of other if thats true return false;
                foundDifference = true; // make the true incase of first difference. 
                if(s1.length() == s2.length()) {
                    //incase of both the string length is same. case of string replace. 
                    index1 ++;
                }
            }else index1 ++;
                index2++;  
            } 
        return true;   
    }
    public static void main(String[] args) {
        boolean istrue = oneEditAway("anand", "knand");
        System.out.println(istrue);
    }

}
