package FinalExam;

public class Node {

  /** Node's payload is just a string */
  private String payload;
  /** Pointer to next node */
  private Node next;

  /**
   * Basic constructor
   * 
   * @param payload String to store in node
   */
  public Node(String payload) {
    this.payload = payload;
    this.next = null;
  } // basic constructor

  /**
   * Set a node's next node
   *
   * @param next Node that this node will point to
   */
  public void setNext(Node node) {
    this.next = node;
  } // method setNext

  /**
   * Boolean about next node
   * 
   * @return true if this node has a next one, false otherwise
   */
  public boolean hasNext() {
    return this.next != null;
  } // method hasNext

  /**
   * Checks if a node has a specific number of nodes after it
   *
   * @param howMany int number of nodes this node is expected to have after it
   */
  public boolean hasNext(int howMany) {
    //SOLUTION:
    //return this.getNext(howMany) != null;
  // method hasNext(int)
    
  //STUDENT ANSWER:
    Node current = this;
    //loops through the list until the end or the desired node is reached
    //basically does what getNext(int) does but returns a boolean
    for (int i = 0; i < howMany && current != null; i++) {
        current = current.getNext();
    }
    // if the desired node is reached, return true
    return current != null;
}
// method hasNext(int)

  /**
   * Get a node's next node.
   * 
   * @return the next node object, or null if none.
   */
  public Node getNext() {
    return this.next;
  } // method getNext

  /**
   * Obtain the next.next...next node from this node
   * 
   * @param howMany int with the number of nodes to skip
   * @return Node after so many hops or null if end of list
   */

   //SOLUTION:
  /*public Node getNext(int howMany) {
    Node current = this;
    int count = 0;
    while (count < howMany && current != null) {
      current = current.getNext();
      count++;
    }
    return current;
  } // method getNext(int)
  */
  //MY ANSWER:
   public Node getNext(int howMany) {
    Node current = this;

    // in case user enters a negative number or the current node is null
    if (howMany < 0 || current == null) {
        return current; 
    }

    // loop through the list until the end or the desired node is reached
    for (int i = 0; i <= howMany && current != null; i++) {
        current = current.getNext(); 
    }

    return current;
}
 // method getNext(int)


  /**
   * Obtain a node's data content (its payload)
   * 
   * @return String with node's payload
   */
  public String getPayload() {
    return this.payload;
  } // method getPayload

  /**
   * String representation of the node object
   * 
   * @return String with information about the node
   */
  public String toString() {
    String nextPayload = (this.next == null) ? "null" : this.getNext().getPayload();
    return String.format("((%s)) --> (%s)",
        this.payload,
        nextPayload);
  } // method toString

}