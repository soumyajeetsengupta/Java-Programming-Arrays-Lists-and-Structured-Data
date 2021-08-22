import edu.duke.*;

/**
 * Write a description of WordPlay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WordPlay {
    public boolean isVowel(char ch) {
        String vowel = "AEIOU";
        int count = 0;
        if(Character.isLowerCase(ch))
        vowel = vowel.toLowerCase();
        for(int i = 0; i <  5; i++) {
            if(vowel.charAt(i) == ch) {
                count++;
            }
        }
        if(count>0)
        return true;
        else 
        return false;
    }
    public String replaceVowels(String phrase, char ch) {
        StringBuilder word = new StringBuilder(phrase);
        for(int i = 0; i < phrase.length(); i++){
            if(isVowel(word.charAt(i))){
                word.setCharAt(i, ch);
            }
        }
        return word.toString();
    }
    
    public String emphasize(String phrase, char ch) {
        StringBuilder word = new StringBuilder(phrase);
        for(int i = 0; i < phrase.length(); i++) {
            if(isVowel(word.charAt(i))) {
                if(i % 2 == 0) {
                    word.setCharAt(i,'+');
                }
                else {
                    word.setCharAt(i, '*');
                }
            }
        }
        return word.toString();
    }
    
    void test() {
        System.out.println(isVowel('a'));
    }
    void test2(){
        System.out.println(replaceVowels("Hello World", '*'));
    }
    void test3() {
        System.out.println(emphasize("dna ctgaaactga", 'a'));
    }
}
