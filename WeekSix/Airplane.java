public class Airplane implements Travel, Ramp, Command, Maintainance{
    public void climbto(int altitude){

    }
    public void desecentTo(){

    }
    public void TakeOff(){

    }
    public void announce(String string){
        System.out.print(string);
        }
    public void sleep(){
        System.out.print("zzzzz");
    }
    public void land(){
        System.out.print("Are we there yet?")
    }
}
