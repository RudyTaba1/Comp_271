package WeekSix;

public class Airplane implements Travel, Ramp, Command, Maintainance{
    public void climbTo(int altitude){

    }
    public void descentTo(int altitude){

    }
    public void takeOff(){

    }
    public void announce(String string){
        System.out.print(string);
        }
    public void sleep(){
        System.out.print("zzzzz");
    }
    public void land(){
        System.out.print("Are we there yet?");
    }
    public void openCargoDoors(){
        System.out.print("Cargo doors unloaded");
    }
    public void unloadCargo(){
        System.out.print("Luggage Unloaded.");
    }
    public void refuel(){
        System.out.print("You have fuel now.");
    }
    public boolean inspectEngine(int engineNumber){
        return (engineNumber<10);
    }
    

}
