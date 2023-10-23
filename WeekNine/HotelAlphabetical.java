package WeekNine;

public class HotelAlphabetical {
    private static final char FIRST_LETTER_UPPER = 'A';
    private static final char FIRST_LETTER_LOWER = 'a';
    private static final char LAST_LETTER_UPPER = 'Z';
    private static final char LAST_LETTER_LOWER = 'z';
    class Hammock{
   private String guestFirstName;
   private String guestLastName;
      private Hammock(String guestFirstName, String guestLastName) {
      this.guestFirstName = guestFirstName;
      this.guestLastName = guestLastName;
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
    public void addGuest(String firsName, String lastName){
        //first letter of last name
        char firstOfLast = lastName.charAt(0);
        while(startsWithLetter(lastName)&&isLetter(firstOfLast)){
            //add a guest
            
        }
    }
}
}
