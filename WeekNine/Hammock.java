package WeekNine;

    class Hammock{
    
   private static final char FIRST_LETTER_UPPER = 'A';
   private static final char FIRST_LETTER_LOWER = 'a';
   private static final char LAST_LETTER_UPPER = 'Z';
   private static final char LAST_LETTER_LOWER = 'z';
   private Hammock next;
   private String guestFirstName;
   private String guestLastName;
      
   Hammock(String guestFirstName, String guestLastName) {
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
 * @param next is next hammock
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

  }

 