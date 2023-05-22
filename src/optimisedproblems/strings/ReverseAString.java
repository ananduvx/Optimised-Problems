package optimisedproblems.strings;

public class ReverseAString {

    public static void main(String[] args ) {
        String s= "anand";
        System.out.println( reverse(s));
    }

    private static String reverse(String s) {
        StringBuilder t = new StringBuilder();
        for(int i= s.length()-1; i>=0; i--) {
            t.append(s.charAt(i));
        }
        return t.toString();
    }
}
