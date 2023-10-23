package WeekNine;

public class Hammock {
   private String guestFirstName;
   private String guestLastName;
   /**
    * Default constructor. Sets both first and last stations to null.
    */
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
}
