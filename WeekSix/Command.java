package WeekSix;

public interface Command {

    public void descentTo(int altitude);
    public void climbTo(int altitude);
    public void takeOff();
    public void land();
}
