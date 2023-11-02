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
      // Get first letter of last name in upper case
      char firstLetter = lastName.toUpperCase().charAt(0);
      // Convert first letter into an int beween 0 and 26 to find the
      // array position for this guest's hammock.
      int number = (int) firstLetter - (int) 'A';
      // Hammock for the new guest
      Hammock newGuest = new Hammock(firstName, lastName);
      // Let's check the room where guest should go. Anyone already there?
      if (rooms[number] == null) {
        // Room empty, first hammock in room is for new guest.
        rooms[number] = newGuest;
      } else {
        // Room not empty. Guest removes existing hammocks, adds theirs,
        // and attaches other hammocks to their hammock.
        newGuest.setNext(rooms[number]); // new guest at top of existing hammocks
        rooms[number] = newGuest; // new guest first in room
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
}

