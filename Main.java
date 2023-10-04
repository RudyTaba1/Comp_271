import WeekSix.TrainLine;
import WeekSix.person;

public class Main {
    public static void main(String[] args){
        // Realistic line
    TrainLine redLineSB = new TrainLine();
    redLineSB.addStation("Howard");
    redLineSB.addStation("Jarvis");
    redLineSB.addStation("Morse");
    redLineSB.addStation("Loyola");
    redLineSB.addStation("Granville");
    redLineSB.addStation("Thorndale");
    redLineSB.addStation("Bryn Mawr");

    TrainLine BluelinetoOhare = new TrainLine();
    BluelinetoOhare.addStation("Forest Park");
    BluelinetoOhare.addStation("Oak Park");
    BluelinetoOhare.addStation("Austin");
    
    System.out.println(redLineSB.compareTo(BluelinetoOhare));
    System.out.println(redLineSB.compareTo(redLineSB));

    person demo = new person();

    System.out.println(demo.toString());
    }
}