package WeekEleven;

public class HashTable {
     /** Default resize factor for enlarging underlying array */
  private static final int DEFAULT_RESIZE_FACTOR = 2;

  /** Underlying array of linked lists */
  private Node[] table;

  /** Size of underlying table */
  private int size;

  /** Default size for underlying array */
  private static final int SIZE = 4;

  /** How many elements of the underlying array are used */
  private int elementsUsed;

  /** Utilization rate = elements used / length of underlyin array */
  private double loadFactor;

  /** Customized load factor threshold */
  private double loadFactorThreshold;

  /** Load factor threshold for rehashing */
  private static final double LOAD_FACTOR_THRESHOLD = 0.75;

  /** Counts the lengths of linked lists in underlying array */
  private int[] lengths;

  /** What is the longest linked list's length */
  private int longestLL;

  /** Basic constructor */
  public HashTable(int size, double loadFactorThreshold) {
    this.table = new Node[size];
    this.loadFactorThreshold = loadFactorThreshold;
    this.elementsUsed = 0;
    this.loadFactor = 0.0;
    this.lengths = new int[size];
    this.longestLL = 0;
  }

  /** Default constructor */
  public HashTable() {
    this(SIZE, LOAD_FACTOR_THRESHOLD);
  }

  /** Add a string value to the hash table */
  public void add(String value) {
    // Exclude null and empty strings
    if (value != null && value.length() > 0) {
      // Create node object with string value in it
      Node newNode = new Node(value);
      // Which position of the array will this node go to?
      int position = this.hashFunction(value);
      // Is the position is empty or not?
      if (this.table[position] == null) {
        // No other node in position. Just place new node here
        this.table[position] = newNode;
        // One more element used
        this.elementsUsed++;
        this.loadFactor = (double) this.elementsUsed / (double) this.table.length;
      } else {
        // Position occupied. Chain existing nodes behind new one
        newNode.setNext(this.table[position]);
        this.table[position] = newNode;
      }
      // Update the length of linked list we just used above
      this.lengths[position]++;
      // Find longest length and its place in the array
      int longestPosition = 0;
      this.longestLL = this.lengths[longestPosition];
      for (int i = 1; i < this.lengths.length; i++) {
        if (this.lengths[i] > this.longestLL) {
          this.longestLL = this.lengths[i];
          longestPosition = i;
        }
      }
      // Before we leave, it is time to rehash?
      if (this.loadFactor > this.loadFactorThreshold) {
        this.rehash();
      }
    }
  } // method add

  public void rehash() {
    // Backup existing table
    Node[] temp = this.table;
    // Resize table -- data will be lost -- ok, we have backup
    this.table = new Node[DEFAULT_RESIZE_FACTOR * this.table.length];
    // Resize array with length counters
    this.lengths = new int[this.table.length];
    // Reset quantities
    this.loadFactor = 0.0;
    this.elementsUsed = 0;
    // Iterate backup and move data to new table
    for (Node node : temp) {
      Node cursor = node;
      while (cursor != null) {
        this.add(cursor.getValue());
        cursor = cursor.getNext();
      }
    }
  } // method rehash

  /**
   * Find where to place a Node in the underlying array of Nodes
   * using its string value
   */
  public int hashFunction(String value) {
    return Math.abs(value.hashCode()) % this.table.length;
  } // method hashFunction

  /** String representation */
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(String.format("%d/%d elements used; load factor = %.2f",
        this.elementsUsed,
        this.table.length,
        this.loadFactor));
    for (Node node : table) {
      if (node != null) {
        sb.append(String.format("\n[%S]", node.getValue()));
        Node cursor = node.getNext();
        while (cursor != null) {
          sb.append(String.format(" --> [%s]", cursor.getValue()));
          cursor = cursor.getNext();
        }
      } else {
        sb.append("\n[   ]");
      }
    }
    return sb.toString();
  } // method toStrin
}
