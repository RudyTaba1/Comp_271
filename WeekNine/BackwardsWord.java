package WeekNine;
import java.lang.Math;
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
            reverb =  temp + " " + words[0] +" "+ words[1] +" " + words[2]+ " " + words[3];
        }
        return reverb;
    }

    public static boolean isRight(int a, int b, int c){
        boolean right = false;
        c = Math.max(a, Math.max(b,c));
        double pytho = Math.pow(a, 2) + Math.pow(b, 2);
        if(pytho == Math.pow(c, 2) && a+b>c){
            right = true;
        }
        return right;
    }

    public static void main (String[] args){

        System.out.println(everyOtherWordBackwards("Boy these loops are hard!"));
        
        
    }
}
