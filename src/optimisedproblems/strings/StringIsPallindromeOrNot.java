package optimisedproblems.strings;

// used two pointer approach;
public class StringIsPallindromeOrNot {
    public static void main(String args[]) {
    String s = "ananaj";
    System.out.println(IsPallindrome(s));
    }

    private static Boolean IsPallindrome(String s) {
        int n= s.length();
        int i=0, j=n-1;
        while(i<n) {
            if(s.charAt(i)== s.charAt(j)) {
                i++;
                j--;
            }
            else return false;
        }
      return true;
    }
}
