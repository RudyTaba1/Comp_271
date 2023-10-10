package WeekSix;

public interface Command {

  public void land();
  public void takeOff();
  public void climbTo(int altitude);
  public void descentTo(int altitude);
  
}
