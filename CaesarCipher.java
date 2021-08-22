import edu.duke.*;
/**
 * Write a description of CaesarCipher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CaesarCipher {
    public String encrypt(String input, int key) {
        StringBuilder encrypted = new StringBuilder(input);
        //                 01234567890123456789012345
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int check = 0;
        String shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0, key);
        System.out.println("For me to understand key: "  + shiftedAlphabet);
        for(int  i = 0; i < encrypted.length(); i++) {
            char currChar = encrypted.charAt(i);
            if(Character.isLowerCase(currChar)) {
                currChar = Character.toUpperCase(currChar);
                int idx = alphabet.indexOf(currChar);
                if  (idx != -1) {
                    char newChar = shiftedAlphabet.charAt(idx);
                    newChar = Character.toLowerCase(newChar);
                    encrypted.setCharAt(i, newChar);
                }
                
            }
            else {
                int idx = alphabet.indexOf(currChar);
                if  (idx != -1) {
                    char newChar = shiftedAlphabet.charAt(idx);
                    encrypted.setCharAt(i, newChar);
                }
                currChar =  Character.toUpperCase(currChar);
            }
        }
        return encrypted.toString();
    }
    public void testCaesar() {
        int key = 17;
        FileResource fr = new FileResource();
        String message = fr.asString();
        String encrypted = encrypt(message, key);
        System.out.println(encrypted);
        String decrypted = encrypt(encrypted, 26-key);
        System.out.println(decrypted);
    }
    public void test() {
        System.out.println(encrypt("FIRST LEGION ATTACK EAST FLANK!", 23));
    }
    
    public String encryptTwoKeys(String phrase, int key1, int key2) {
        StringBuilder encrypted = new StringBuilder(phrase);
        //                 01234567890123456789012345
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        //System.out.println("For me to understand key: "  + shiftedAlphabet);
        int allow = 0;
        int key = 0;
        for(int  i = 0; i < encrypted.length(); i++) {
            char currChar = encrypted.charAt(i);
            if(allow > 0) {
                key = key1;
                String shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0, key);
                if(Character.isLowerCase(currChar)) {
                    currChar = Character.toUpperCase(currChar);
                    int idx = alphabet.indexOf(currChar);
                    if  (idx != -1) {
                        char newChar = shiftedAlphabet.charAt(idx);
                        newChar = Character.toLowerCase(newChar);
                        encrypted.setCharAt(i, newChar);
                    }
                }
                else {
                    int idx = alphabet.indexOf(currChar);
                    if  (idx != -1) {
                        char newChar = shiftedAlphabet.charAt(idx);
                        encrypted.setCharAt(i, newChar);
                    }
                    currChar =  Character.toUpperCase(currChar);
                }
                allow--;
            }
            else {
                key = key2;
                String shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0, key);
                if(Character.isLowerCase(currChar)) {
                    currChar = Character.toUpperCase(currChar);
                    int idx = alphabet.indexOf(currChar);
                    if  (idx != -1) {
                        char newChar = shiftedAlphabet.charAt(idx);
                        newChar = Character.toLowerCase(newChar);
                        encrypted.setCharAt(i, newChar);
                    }
                }
                else {
                    int idx = alphabet.indexOf(currChar);
                    if  (idx != -1) {
                        char newChar = shiftedAlphabet.charAt(idx);
                        encrypted.setCharAt(i, newChar);
                    }
                    currChar =  Character.toUpperCase(currChar);
                }
                allow++;
            }
        }
        return encrypted.toString();
    }
    public void test3() {
        System.out.println(encryptTwoKeys("First Legion", 17, 23));
    }
}