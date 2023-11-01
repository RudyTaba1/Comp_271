package WeekNine;
import WeekNine.Hammock;

public class HotelAlphabetical {
    private static final char FIRST_LETTER_UPPER = 'A';
    private static final char FIRST_LETTER_LOWER = 'a';
    private static final char LAST_LETTER_UPPER = 'Z';
    private static final char LAST_LETTER_LOWER = 'z';
    class Hammock{
    private Hammock next;
   private String guestFirstName;
   private String guestLastName;
      private Hammock(String guestFirstName, String guestLastName) {
      this.guestFirstName = guestFirstName;
      this.guestLastName = guestLastName;
      this.next = null;
   }

   /**
    * gets the guest's first name
    * @return first name
    */
   public String getGuestFirstName() {
      return this.guestFirstName;
   }

   /**
    * gets the guest's last name
    * @return last name
    */
    public String getGuestLastName() {
        return this.guestLastName;
    }

    /**
     * toString call
     */
   public String toString() {
      return this.guestFirstName + " " + this.guestLastName;
   }

   /**
    * sets the next hammock
    * @param next the next hammock
    */  
   public boolean hasNext(){
        return this.next != null;
   }

   /**
    * gets the next hammock
    * @return the next hammock
    */
   public Hammock getNext(){
        return this.next;
   }
   
   /**
    * sets the next hammock
    * @param next the next hammock
    */
   public void setNext(Hammock next){
        this.next = next;
   }
   //underlying array for the hotel
   Hammock[] rooms = new Hammock[26];

   /**
    * verifies whether or not input of string is valid (a word)
    * @param c is <string>.charAt(0)
    * @return word or not word
    */
   public boolean isLetter(char c){
         return (c >= FIRST_LETTER_UPPER && c <= LAST_LETTER_UPPER) || (c >= FIRST_LETTER_LOWER && c <= LAST_LETTER_LOWER);
   }
   public boolean startsWithLetter(String string){
         return string != null && isLetter(string.charAt(0));
   }
   
   /**
     * adds a guest to the hotel
     * @param guest the guest to add
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
  }

}
}
