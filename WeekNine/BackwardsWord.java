package WeekNine;

public class BackwardsWord {
    /**
     * Write a method that takes a string and returns a string with every other word backwards.
     * @param back
     * @return
     */
    public static String everyOtherWordBackwards(String back){
        String [] words = new String[100];
        String temp = "";
        String reverb = "";
        char space = ' ';
        int j = 0;
        for(int i = back.length()-1; i+1>0; i--){
            temp += back.charAt(i);
        }
        for(int i = 0; i<temp.length(); i++){
            if(temp.charAt(i) == space){
                words[j] = temp.substring(0, i);
                temp = temp.substring(i+1);
                i = 0;
                j++;
            }
        }
        return reverb;
    }

    public static void main (String[] args){
        System.out.print(everyOtherWordBackwards("Boy these loops are tricky!"));
    
    }
}
