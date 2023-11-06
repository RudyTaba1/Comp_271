package WeekEleven;

public class Node {

  /** Data stored in the node; could be anything, here just a string */
  public String value;

  /** Next node in the linked list */
  public Node next;

  // THE USUAL SUSPECTS ....

  /** Basic constructor */
  public Node(String value) {
    this.value = value;
    this.next = null;
  }

  /** Setter for next */
  public void setNext(Node next) {
    this.next = next;
  }

  /** Getter for next */
  public Node getNext() {
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

} // class Node
