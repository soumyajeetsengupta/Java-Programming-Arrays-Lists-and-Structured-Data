import edu.duke.*;

/**
 * Write a description of WordLengths here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WordLengths {
    public int count(String s) {
        //StringBuilder sb = new StringBuilder(s);
        int len = s.length();
        System.out.println(s);
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            ch = Character.toLowerCase(ch);
            if(i == 0){
                if(i == s.length()-1) {
                    if(!Character.isLetter(ch)) {
                        len-=1;
                        len-=2;
                    }
                }
            }
            else if(!Character.isLetter(ch)) {
                len--;
            }
        }
        return len;
    }
        
    
    public void countWordLengths (FileResource resources, int[] counts) {
        int maxlen = 0;
        for(String wordlength: resources.words()){
            if(maxlen < wordlength.length()){
                maxlen = wordlength.length();
                //System.out.println(maxlen);
            }
        }
        int[] arr = new int[maxlen+1];
        for(String s: resources.words()) {
            //int len = s.length();
            int len = count(s);
            //System.out.println(s);
            arr[len]++;
        }
        for(int k = 0 ; k < maxlen+1; k++){
            if(arr[k] != 0) {
                System.out.print(arr[k] + " words of length "+ k + ". ");
                System.out.println();
            }
        }
        System.out.println(indexOfMax(arr));
    }
    
    public int indexOfMax (int[] values) {
        int max = 0;
        for(int i = 0; i < values.length; i++){
            if(max < values[i]){
                max = values[i];
            }
        }
        int i;
        for(i = 0; i < values.length; i++) {
            if(max == values[i]){
                break;
            }
        }
        return i;
    }
    
    void test(){
        FileResource fr = new FileResource();
        int arr[] = new int[5];
        countWordLengths(fr, arr);
    }
    
    void lentest() {
        System.out.println(count("\"Hello\""));
    }
    
    void testCountWordLengths () {
        FileResource fr = new FileResource();
        int arr[] = new int[31];
        countWordLengths(fr, arr);
    }
}
