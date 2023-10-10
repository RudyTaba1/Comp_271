package WeekSix;

public class Airplane
    implements Command, Travel, Maintainance, CabinService, Ramp {

  public boolean inspectEngine(int engineNumber) {
    return true;
  }

  public void openCargoDoors() {
    System.out.println("Cargo doors open.");
  }

  public void unloadCargo() {
    System.out.println("No more luggages in the cargo hold.");
  }

  public void refuel() {
    System.out.println("You have been refueled.");
  }

  public void announce(String string) {
    System.out.println(string);
  }

  public boolean pretakeoffInspection() {
    return true;
  }

  public void board() {
    System.out.println("I am on a plane. Let's post something on TikTok!");
  }

  public void sleep() {
    System.out.println("Zzzzzzzzzzzzz");
  }

  public void land() {
    System.out.println("Welcome to Chicago.");
  }

  public void takeOff() {
    System.out.println("Hiyaaaaaaaaaa");
  }

  public void climbTo(int altitude) {
    if (altitude < 50000) {
      System.out.println("Climbing to " + altitude + " feet");
    } else {
      System.out.println("Unable");
    }
  }

  public void descentTo(int altitude) {
    if (altitude < 0) {
      System.out.println("Yeah, whatever");
    } else {
      System.out.println("Descent to " + altitude + " feet");
    }
  }

}