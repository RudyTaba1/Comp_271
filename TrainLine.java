/**
 * A class that simulates a train line by linking train station objects 
 * together. The class uses two train station objects to define a train
 * line: its first station and its last station. New stations are added
 * always at the end of the line, and that's why it's important to know
 * where the last station is.
 */
public class TrainLine {

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
   * Default constructor. Sets both first and last stations to null.
   */
  public TrainLine() {
    this.first = null;
    this.last = null;
  } // default constructor

  /**
   * Add a train station at the back of the train line. The new station
   * will become the last station in the line.
   *
   * @param name String with name of new station to add.
   */
  public void addStation(String name) {
    // Create the new train station to add
    TrainStation newStation = new TrainStation(name);
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
   * Determine if a train station with a given name exists in the train line.
   *
   * @param name String with name of train station to search the train line for
   * @return true if train station with given name exists in line,
   *         false, otherwise.
   */
  public boolean contains(String name) {
    // Assume station doesn't exist
    boolean found = false;
    // Search only if line is not empty
    if (this.first != null) {
      // Line not empty; proceed with search starting from first station
      TrainStation cursor = this.first;
      // Explore every station until we exit the train line by arriving
      // at the null that the last station points to or until we find a
      // station with the given name.
      while (cursor != null && !found) {
        // Check if current station (where the cursor is) matches the name
        found = cursor.getName().equals(name);
        // Proceed to the next station
        cursor = cursor.getNext();
      }
    }
    return found;
  } // method contains

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
   * the TrainStation findmiddle() method finds the middle line by analyzing fast traveler and slow traveler.
   * if the fast traveler has a nextStation to travel to, and then additionally, if the fast traveler has an additional 
   * station to travel after that, and that it exists (.getNext()&&.hasNext()) then @return slow travelers position in reference to 
   * fast traveler
   */
  public TrainStation findmiddle(){
    TrainStation fast = this.first;
    TrainStation slow = this.last;
    while(fast.hasNext() && fast.getNext().hasNext()){
        fast = last.getNext().getNext();
        slow = slow.getNext();

    }
    return slow;
  }

} // class TrainLine