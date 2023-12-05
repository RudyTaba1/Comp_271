package WeekEleven;

public class OurHashTable {

  /** Default resize factor for enlarging underlying array */
  private static final int DEFAULT_RESIZE_FACTOR = 2;

  /**
   * Underlying array of linked lists. The "first" node of each linked
   * list is added as an element to the array. New nodes to that linked
   * list are placed as elements to the same position in the array, with
   * the existign chain of nodes attached behind them.
   */
  private NewNode[] table;

  /** Default size for underlying array */
  private static final int SIZE = 4;

  /**
   * How many elements of the underlying array are used. This is not the
   * total number of nodes present in the underlying array. Stricly the
   * number of elements used in the array. For example, an array may have
   * 4 elements, and only one of them used. That single element may contain
   * a linked list with multiple nodes.
   */
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
  private int longestList;

  /** Basic constructor */
  public OurHashTable(int size, double loadFactorThreshold) {
    this.table = new NewNode[size];
    this.loadFactorThreshold = loadFactorThreshold;
    this.elementsUsed = 0;
    this.loadFactor = 0.0;
    this.lengths = new int[size];
    this.longestList = 0;
  }

  /** Default constructor */
  public OurHashTable() {
    this(SIZE, LOAD_FACTOR_THRESHOLD);
  }

  /**
   * Add a string value to the hash table. Method accepts a non-empty string,
   * determines which position in the underlying array to place it, and adds
   * it accordingly. Position determination is modulo-based. Placement is done
   * by creating a node with the string and making the node the first node in
   * a link list. That first node is then placed in the determined position of
   * the underlying array.
   *
   */
  public void add(String value) {
    // Exclude null and empty strings
    if (value != null && value.length() > 0) {
      // Create node object with string value in it
      NewNode newNode = new NewNode(value);
      // Which position of the array will this node go to? We delegate
      // the decision to method hashFunction.
      int position = this.hashFunction(value);
      // Is the specified position in the underlying array empty or not?
      if (this.table[position] == null) {
        // No other node in position. Just place new node here
        this.table[position] = newNode;
        // We are not using one more element in the underlying array. Time
        // to update the count of such elements, and the load factor.
        this.elementsUsed++;
        this.loadFactor = (double) this.elementsUsed / (double) this.table.length;
      } else {
        // Position occupied. Chain existing nodes behind new one
        newNode.setNext(this.table[position]);
        // Place new node (that now has the previous occupants of [position]
        // attached after it) to [position]
        this.table[position] = newNode;
      }
      // Update the length of linked list we just used
      this.lengths[position]++;
      // Find longest length and its place in the array.
      int longestPosition = 0;
      this.longestList = this.lengths[longestPosition];
      for (int i = 1; i < this.lengths.length; i++) {
        if (this.lengths[i] > this.longestList) {
          this.longestList = this.lengths[i];
          longestPosition = i;
        }
      }
      // Before we leave, it is time to rehash?
      if (this.loadFactor > this.loadFactorThreshold) {
        this.rehash();
      }
    }
  } // method add

  /**
   * Increases the size of the underlying array and adds all the nodes
   * back to it. This results to an object with lower load factor than
   * before. It also yields a data structure with shorter linked lists
   * in it.
   */
  public void rehash() {
    // Backup existing table
    NewNode[] temp = this.table;
    // Resize table -- data will be lost -- ok, we have backup
    this.table = new NewNode[DEFAULT_RESIZE_FACTOR * this.table.length];
    // Resize array with length counters
    this.lengths = new int[this.table.length];
    // Reset quantities
    this.loadFactor = 0.0;
    this.elementsUsed = 0;
    // Iterate backup and move data to new table
    for (NewNode node : temp) {
      NewNode cursor = node;
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
    for (NewNode node : table) {
      if (node != null) {
        sb.append(String.format("\n[%S]", node.getValue()));
        NewNode cursor = node.getNext();
        while (cursor != null) {
          sb.append(String.format(" --> [%s]", cursor.getValue()));
          cursor = cursor.getNext();
        }
      } else {
        sb.append("\n[   ]");
      }
    }
    return sb.toString();
  } // method toString
}