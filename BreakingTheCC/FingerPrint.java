import edu.duke.*;
/**
 * Write a description of FingerPrint here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FingerPrint {
    public void textFingerPrint(String s) {
        String alpha = "abcdefghijklmnopqrstuvwxyz";
        int[] counter = new int[26];
        for(int k = 0; k < s.length(); k++) {
            char ch = s.charAt(k);
            int index = alpha.indexOf(Character.toLowerCase(ch));
            if(index != -1) {
                counter[index] += 1;
            }
        }
        for(int k = 0; k < counter.length; k++) {
            System.out.println(alpha.charAt(k) + "\t" + counter[k]);
        }
    }
    void test1() {
        textFingerPrint("Anneyeonghaseyo");
    }
}
