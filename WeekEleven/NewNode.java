package WeekEleven;

class NewNode {
    /** Data stored in the node; could be anything, here just a string */
  public String value;

  /** Next node in the linked list */
  public NewNode next;

  // THE USUAL SUSPECTS ....

  /** Basic constructor */
  public NewNode(String value) {
    this.value = value;
    this.next = null;
  }

  /** Setter for next */
  public void setNext(NewNode next) {
    this.next = next;
  }

  /** Getter for next */
  public NewNode getNext() {
    return this.next;
  }

  /** Boolean for next */
  public boolean hasNext() {
    return this.next != null;
  }

  /** Getter for value */
  public String getValue() {
    return this.value;
  }


}
