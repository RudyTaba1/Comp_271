package WeekNine;

public class Tutor {

    public boolean isReal(int positive, int negative){
        boolean real = false;
        if(positive > 0 && negative < 0){
            real = true;
        }
        return real;
    }
    public String doesRealWork(int num1, int num2){
        String real = "yay it works";
        String notreal = "uhoh did it wrong";

        if(isReal(num1, num2)){
            return real;
        }
        else{
            return notreal;
        }
    }
public static void main(String[] args) {
    Tutor t = new Tutor();
    System.out.println(t.doesRealWork(1, -1));
}
}
