package WeekNine;
import WeekSix.TrainStation;
/**
 * A class that simulates a train line by linking train station objects
 * together. The class uses two train station objects to define a train
 * line: its first station and its last station. New stations are added
 * always at the end of the line, and that's why it's important to know
 * where the last station is.
 */
public class SimpleTrainLine {

  /** Constant with message for string representation of an empty line */
  private static final String EMPTY_LINE = "This train line has no stations.";

  /**
   * The first station in the train line. This field is significant because
   * it provides us with a starting point for traversing the train line in
   * search of a particular station or for other purposes when traversal is
   * necessary.
   */
  private TrainStation first;

  /**
   * The last station in the train line. This field is significant because it
   * allows us to add new stations at the end of the line, superfase.
   */
  private TrainStation last;

  /**
   * Number of stations in a line. Neeeded for Comparable.
   */
  private int numberOfStations;

  /**
   * Default constructor. Sets both first and last stations to null.
   */
  public SimpleTrainLine() {
    this.first = null;
    this.last = null;
    this.numberOfStations = 0;
  } // default constructor

  /** Accessor for numberOfStations */
  public int getNumStations() {
    return this.numberOfStations;
  }

  /** Accessor for first station */
  public TrainStation getFirst() {
    return this.first;
  }

  /**
   * Add a train station at the back of the train line. The new station
   * will become the last station in the line.
   *
   * @param name String with name of new station to add.
   */
  public void addStation(String name) {
    // Create the new train station to add
    TrainStation newStation = new TrainStation(name);
    this.numberOfStations++;
    // Determine where to add the new train station
    if (this.first == null) {
      // Train line is empty: this is the first station we add
      this.first = newStation;
    } else {
      // Train line not empty: new station goes after last station
      this.last.setNext(newStation);
    }
    // Update the last station to the newly added station
    this.last = newStation;
  } // method addStation

  /**
   * Overloaded method addStation to take a TrainStation object as param.
   */
  public void addStation(TrainStation trainStation) {
    if (this.first == null) {
      this.first = trainStation;
    } else {
      this.last.setNext(trainStation);
    }
    this.last = trainStation;
  } // method addStation

 
  
  /**
   * String representation of the train line object, demonstrating the use
   * of StringBuilder.
   */
  public String toString() {
    StringBuilder sb = new StringBuilder();
    if (this.first == null) {
      // Line is empty
      sb.append(EMPTY_LINE);
    } else {
      // Line not empty, traverse and print its stations
      TrainStation current = this.first;
      while (current != null) {
        sb.append(String.format("\n%s", current.getName()));
        current = current.getNext();
      }
    }
    return sb.toString();
  } // method toString

  /**
   * Accessor for reverseIteratively() method.
   * @return reversed array when called.
   */
  public String reverseRecursively() {
    return reverseIteratively(this.first);
}


/**
 * Helper method to reverse the line recursively.
 * @param current is a TrainStation object that defaults to this.first (the first station in the line), and will then be stored to @param reversed last.
 * Assuming the string is not empty, the method will push the remaining lines through another string, @param linesRemaining, 
 * by calling the method again with the next station in the line as the parameter and then add it to the reversed string.
 * @return will return the reversed array.
 */
private String reverseIteratively(TrainStation current) {
  String reversed = "";
  // assuming the this.first is not empty
  if (current != null) {
      String lineRemaining = reverseIteratively(current.getNext());
    // if the next station is not null, then store to reversed
      if (lineRemaining != null && lineRemaining.length() > 0) {
          reversed = lineRemaining + ", ";
      }
  // this will add the first station to the last element of the reversed string.
      reversed += current.getName();
  }
  return reversed;
}// method reverseIteratively()

} // class TrainLine