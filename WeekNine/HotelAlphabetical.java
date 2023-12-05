package WeekNine;
import WeekNine.Hammock;

/**
 * A rather spooky hotel, where guests are sent to one of its 26 rooms, and
 * stay on a hammock; if there are multiple guests assigned to a room, the
 * most recent guest get the top hammock and the remaining guests' hammocks
 * are appended below the first guest's hammoc.
 */
public class HotelAlphabetical {

/** Constant with number of letters in alphabet */
  private static final int DEFAULT_NUMBER_OF_ROOMS = 4;

  /** Constant with SPACE */
  private static final String SPACE = " ";

  /** Array of chainable hammocks. One hammock chain per room */
  Hammock[] room;

  /** Length of longest last name - for nice printing */
  private int longestLastName; 

  /** How many guests are in the hotel */
  private int guests; 

  /** How many rooms are occupied? */
  private int occupiedRooms; 

  /** load factor of hotel rooms = rooms occupied/total rooms */
  private double loadFactor; // DEVELOPED IN CLASS 11/3
  /** Threshold to resize and rehash the hotel */
  private static final double LOAD_FACTOR_THRESHOLD = 0.75;  // DEVELOPED IN CLASS 11/3
  /** Resize factor for the when it's time to increase hotel capacity */
  private static final int RESIZE_FACTOR = 2;  // DEVELOPED IN CLASS 11/3  /** Constant with number of letters in alphabet */
  private static final int NUMBER_OF_LETTERS = 26;

  /** Array of chainable hammocks. One hammock chain per room */
  Hammock[] rooms = new Hammock[NUMBER_OF_LETTERS];

  /**
   * Determine if a char is an actual letter.
   * (Yes, we can do this with a regex but where's the fun in that?)
   * 
   * @param character char to determine if it's an actual letter
   * @return true if character is Aa-Zz, false otherwise.
   */
  static public boolean isLetter(char character) {
    return ((character >= 'A' && character <= 'Z') ||
        (character >= 'a' && character <= 'z'));
  } // isLetter

  /**
   * Determine if a string starts with an true alphabetical character.
   * 
   * @param string String we test to see if first char is letter.
   * @return true if first character is letter, false otherwise
   *         or when string is null or empty.
   */
  static public boolean startsWithLetter(String string) {
    return (string != null && // guard against null entry
        string.length() > 0 && // guard against empty string
        isLetter(string.charAt(0)) // check string's first char
    );
  } // method startsWithLetter

    private int assignRoom(String lastName) {
    // return ((int) lastName.toUpperCase().charAt(0) - (int) 'A') % this.rooms.length;
    // return lastName.length() % this.rooms.length;
    return Math.abs(lastName.hashCode()) % this.rooms.length;  // DEVELOPED IN CLASS 11/3
  }
  
  /**
   * Add a guest to the hotel by finding the corresponding room label
   * and sending them to that room with their hammock.
   *
   * @param firstName string with guest's first name
   * @param lastName  string with guest's last name
   */

  public void addGuest(String firstName, String lastName) {
    // Guard againsts invalid last name
    if (startsWithLetter(lastName)) {
      // Convert first letter into an int beween 0 and 26 to find the
      // array position for this guest's hammock.
      int number = assignRoom(lastName);
      // Hammock for the new guest
      Hammock newGuest = new Hammock(firstName, lastName);
      // Let's check the room where guest should go. Anyone already there?
      if (rooms[number] == null) {
        // Room empty, first hammock in room is for new guest.
        rooms[number] = newGuest;
        // One more room is now occupied
        this.occupiedRooms++; 
        // Since one more room is now used, update load factor
        // DEVELOPED IN CLASS 11/3
        this.loadFactor = (double) this.occupiedRooms / (double) this.rooms.length;
      } else {
        // Room not empty. Guest removes existing hammocks, adds theirs,
        // and attaches other hammocks to their hammock.
        newGuest.setNext(rooms[number]);
        rooms[number] = newGuest;
      }
      // Update longest name length
      if (lastName.length() > this.longestLastName) { 
        this.longestLastName = lastName.length(); 
      }
      // Update number of occupants
      this.guests++; 
      // Before leaving, let's see if it's time to resize and rehash
      if (this.loadFactor > LOAD_FACTOR_THRESHOLD) { // DEVELOPED IN CLASS 11/3
        this.rehash();  // DEVELOPED IN CLASS 11/3
      }
    }
  } // method addGuest

  /**
   * String representation
   *
   * @return String representation of object
   */
  public String toString() {
    // Using StringBuilder for demo
    StringBuilder sb = new StringBuilder();
    sb.append("Showing only rooms with guests -- empty rooms ommitted.");
    for (int i = 0; i < this.rooms.length; i++) {
      // Check if room not empty
      if (this.rooms[i] != null) {
        // Create room label
        char roomLabel = (char) ((int) 'A' + i);
        sb.append(String.format("\n[ %s ]: | ", roomLabel));
        Hammock guestHammock = this.rooms[i];
        while (guestHammock != null) {
          sb.append(String.format("%s, %s. | ",
              guestHammock.getGuestFirstName(),
              guestHammock.getGuestLastName().charAt(0)));
          guestHammock = guestHammock.getNext();
        }
      }
    }
    return sb.toString();
  }

  /**
   * Resize and rehash the hotel
   */
  public void rehash() { // DEVELOPED IN CLASS 11/3
    // Create a temporary copy of the hotel's occupants
    Hammock[] temp = this.rooms;
    // Increase the size of the rooms array -- its existing data will be lost
    // but we have a copy in array temp
    this.rooms = new Hammock[RESIZE_FACTOR*this.rooms.length];
    // Now we have a new hotel, reset its characteristics. No need to reset
    // longest last name, since we are using the same data.
    this.guests = 0;
    this.occupiedRooms = 0;
    this.loadFactor = 0.0;
    // Go through every guest in array temp and rehash them to the new array.
    for (int i = 0; i < temp.length; i++) {
      Hammock cursor = temp[i];
      while (cursor != null) {
        this.addGuest(cursor.getGuestFirstName(), cursor.getGuestLastName());
        cursor = cursor.getNext();
      }
    }
  } // method rehash


  /**
   * another .toString() call that prints occupied rooms, 
   * amount of guests in each room, and the longest last name in the hotel
   */

   /*  public String toString() {
    String result = "";
    int fullRooms = 0;
    int EmptyRooms = 0;
    int longest = 0;
    // Loop through rooms
    for(int i = 0; i < NUMBER_OF_ROOMS; i++) {
      // Guard against null room
      if (rooms[i] != null) {
        fullRooms++;
        EmptyRooms = (NUMBER_OF_ROOMS - fullRooms);
      }
      Hammock currentHammock = this.rooms[i];
      //find the longest last name
      while(currentHammock != null){
        //if the length of the last name is greater than the longest, replace it
        if(currentHammock.getLastName().length() > longest){
          longest = currentHammock.getLastName().length();
        }
        //cycle through it
          currentHammock = currentHammock.getNext();
      }
      //add results
      result = "There are " + EmptyRooms + " guests at the hotel, occupying " + fullRooms + " rooms.\n";
      result += EmptyRooms + " rooms are empty.\n";
      result += "The longest last name is " + longest + " characters long.\n";
    }
    return result;
  }
 * 
 */

 /**
  * proper tostring method without making it do math and such
  */
  /**
   *   public String tooString() { // ADDED FOR HOMEWORK 8 SOLUTION
    return String.format("There are %d guest at the hotel, occuping %d rooms." +
        "\n%d rooms are currently empty" +
        "\n\nThe longest last name we have is %d characters long.",
        this.guests,
        this.occupiedRooms,
        this.rooms.length - this.occupiedRooms,
        this.longestLastName);
  }

   */
}

