package ArraysAndStrings;
/**
 * method to urlify the string of space with %20
 * @author Anand
 * Approch1.
 *    
 *
 */
public class Urlify {
   private static char[] replaceSpace(char[] str, int trueLength) {
       int spaceCount = 0,index,i = 0;
       //Count the number of spaces. 
       for(i =0; i< trueLength; i++) {
           if(str[i] == ' ') {
               spaceCount ++;   
           }
       }
       // original length after addition = spaceCount*(3-1)+previous length
       index = trueLength+ spaceCount*2;
       if(trueLength< str.length) str[trueLength] = '\0';   // trim the last space.
       // insert into string now.
       //start traversing from end 
       for(i = trueLength-1; i>=0; i--) {
           // if we get the space from end then will insert.
           if(str[i] == ' ') {
               str[index-1] = '0';
               str[index-2] = '2';
               str[index-3] = '%';
               index = index-3;
           }
           else {
               str[index-1]= str[i];
               index--;
           }
       }
       return str;
   }
   
   public static int findLastCharacter(char[] str) {
       for (int i = str.length - 1; i >= 0; i--) {
           if (str[i] != ' ') {
               System.out.println(i);
               return i;
           }
       }
       return -1;
   }
        
    public static void main(String[] args) {
        String s = "Mr John Smith    ";
        char[] arr = s.toCharArray();
        int trueLength = findLastCharacter(arr) + 1;
        char[] arr1 = replaceSpace(s.toCharArray(),trueLength);
        System.out.println(arr1);
        
    }
}
