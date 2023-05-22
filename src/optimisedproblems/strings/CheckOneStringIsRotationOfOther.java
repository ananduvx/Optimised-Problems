package optimisedproblems.strings;

//Concate the same string and then check if the string 2 contains inside the concatenated or not. 
public class CheckOneStringIsRotationOfOther {

    public static boolean areRotations(String str1, String str2) {
        // base condition
        if (str1.length() != str2.length()) {
            return false;
        }
        int n = str1.length();
        // Find the starting index of str2 in the concatenated string
        int index = -1;
        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) == str2.charAt(0)) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            return false;
        }

        // Check if str2 is a rotation of str1 by comparing characters
        for (int i = 0; i < n; i++) {
            int j = (index + i) % n;
            if (str1.charAt(j) != str2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String str1 = "abcd";
        String str2 = "cdab";

        if (areRotations(str1, str2)) {
            System.out.println("The strings are rotations of each other.");
        } else {
            System.out.println("The strings are not rotations of each other.");
        }
    }
}

//second approach
//public class StringRotationChecker {
//    public static boolean areRotations(String str1, String str2) {
//        if (str1.length() != str2.length()) {
//            return false;
//        }
//        
//        String concatenated = str1 + str1;
//        
//        return concatenated.contains(str2);
//    }
//    
//    public static void main(String[] args) {
//        String str1 = "abcd";
//        String str2 = "cdab";
//        
//        if (areRotations(str1, str2)) {
//            System.out.println("The strings are rotations of each other.");
//        } else {
//            System.out.println("The strings are not rotations of each other.");
//        }
//    }
//}












