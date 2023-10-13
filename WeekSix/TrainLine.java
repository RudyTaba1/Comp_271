package WeekSix;
/**
 * A class that simulates a train line by linking train station objects 
 * together. The class uses two train station objects to define a train
 * line: its first station and its last station. New stations are added
 * always at the end of the line, and that's why it's important to know
 * where the last station is.
 */

/**
  * Interfaces: essencially a contract. Using the implements keyword, you can use many differnt interfaces.
  The Compare to interface it will compare two elemenets in the arry and look at their positional data.
  Compare object a position - object b position.
  */
public class TrainLine{

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
/**
 * 
 */
  private int numberOfstations;


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
    this.numberOfstations++;
  } // method addStation


  public void addStation(TrainStation trainStation) {
    if (this.first == null) {
      this.first = trainStation;
    } else {
      this.last.setNext(trainStation);
    }
    this.last = trainStation;
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


/**
 * indexOf() method passes through @param station to search for whether or not
 * the station exists in the line. @param station is then passed through @param search
 * in order to use the .equals method in the TrainStation object.
 * If the object exists, then the @param pos will @return @param sta. If it does
 * not exist, @param pos will return -1.
 */
public int indexOf(String station){
  //passes through string station
  TrainStation search = this.first;
  //initial position if false
  int pos = -1;
  //initializes stations.
  int sta = 0;
    //avoids pointing at nothing.
    while(search != null){
      
      if(search.getName().equals(station)){
        pos = sta;
      }
      search = search.getNext();
      sta++;
 }

  return pos;
}
//method indexOf()

/** 
   * Determine if there is a loop in the trainline 
   *
   * @return true if a loop exists, false otherwise 
   */
public boolean hasLoop(){
  boolean found = false;
    
    TrainStation fast = this.first;
    TrainStation slow = this.first;


    if(this.first != null){
    while(!found && fast.hasNext() && fast.getNext().hasNext()){
      slow = slow.getNext();
      fast = fast.getNext().getNext();
      if(slow.equals(fast)){
        found = true;
      }
      
    }
  }
    

return found;
   }//method hasLoop()

    /**
   * Deletes a TrainStation object from the TrainLine.
   */
  public void removeStation(String name) {
    // Empty line guard statement
    if (this.first != null) {
      // Check if station to delete is first station
      if (this.first.getName().equals(name)) {
        //Move first to its next, even if null. (first=null means empt line)
        this.first = this.first.getNext();
        // Did we just delete the only station in the line?
        if (this.first == null) {
          this.last = this.first; // last must also be null
        }
        // Revise number of stations in the TrainLine
        this.numberOfstations--;
      } else {
        // We are not deleting the first station. Go down the line to find
        // the station prior to the one we want delete
        boolean found = false;
        TrainStation cursor = this.first;
        while (!found && cursor.hasNext()) {
          found = cursor.getNext().getName().equals(name);
          cursor = (found) ? cursor : cursor.getNext();
        }
        // Loop stops either because we got to the end of the TrainLine and did
        // not find the station we want to delete, or because we found it.
        // Which of the two is the case?
        if (found) {
          // We have a station to delete; revise number of stations
          this.numberOfstations--;
          // Is it the last station?
          if (cursor.getNext() == this.last) {
            // delete last station
            cursor.setNext(null);
            // Make station prior to last, the new last station
            this.last = cursor;
          } else {
            // Delete station that is not the last, nor the first
            cursor.setNext(cursor.getNext().getNext());
          }
        }
      }
    } // guard if against empty TrainLine 
  } // method deleteStation

/**
 * the insert method passes through two string objects @param afterName and @param newName, in order to 
 * to update and add a trainstation to the trainline, while also returning a boolean value @param success, letting the user
 * know whether the insert and update operation was done successfully.  If the existing parameters are already in the trainline,
 * then @param success will be set to false, as these parameters already exist in the trainline.
 * 
 * The method completes the inserting by setting the @param nN, which passes through new newName, and setting @param nN equal to @param cursor.getNext(),
 * or in other words, inserting nN a position to the right of this.first.  This properly passes through the argument without changing where the last trainstation
 * is pointing.  

 * When successful @param success will @return true.
 */

  public boolean insert(String afterName, String newName) {
    //initialize success
    boolean success = false;
    //trainstation objects to pass arguments through
    TrainStation cursor = this.first;
    TrainStation nN = new TrainStation(newName);
    //avoids null exception error
    if (newName == null || this.contains(newName) || afterName == null) {
        success = false;
        //if the arguments already exist, then just update the position of this.first
    } else if (cursor != null && cursor.getName().equals(afterName)) {
        nN.setNext(cursor);
        this.first = nN; 
        success = true;
    } else {
      //the actual "insert". again, another null protector
        while (!success && cursor != null && cursor.getNext() != null) {
          //completes the insert.
          if (cursor.getNext().getName().equals(afterName)) {
                nN.setNext(cursor.getNext());
                cursor.setNext(nN);
                success = true;
            }
            //update positions and number of stations in the trainline
            cursor = cursor.getNext();
            this.numberOfstations++;
        }
    } 
    return success;
}
//method insert()

  } // class TrainLine