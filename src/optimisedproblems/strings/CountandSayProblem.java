package optimisedproblems.strings;

public class CountandSayProblem {
    public static String countAndSay(int n) {
        if (n <= 0) {
            return "";
        }
        StringBuilder result = new StringBuilder("1");
        for (int i = 2; i <= n; i++) {
            StringBuilder curr = new StringBuilder();
            int count = 1;
            char prevChar = result.charAt(0);

            for (int j = 1; j < result.length(); j++) {
                char currChar = result.charAt(j);
                if (currChar == prevChar) {
                    count++;
                } else {
                    curr.append(count).append(prevChar);
                    count = 1;
                    prevChar = currChar;
                }
            }
            curr.append(count).append(prevChar);
            result = curr;
        }
        return result.toString();
    }

    public static void main(String[] args) {
        int n = 5;
        String result = countAndSay(n);
        System.out.println("The count-and-say subsequence at index " + n + " is: " + result);
    }
}
