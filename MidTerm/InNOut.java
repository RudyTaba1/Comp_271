package MidTerm;
import java.util.Arrays;



/**
 * A simple class to stage input-output processing.
 *
 * The class comprises a humble String array to store data. Data can be placed
 * in the array either before the first item or after the last item. No other
 * random access is allowed. Furthermore, data can be removed only from the
 * front of the array. No random access is allowed for removal. Finally, this
 * object allows us to see what item is at the front of the array without
 * removing it.
 */
public class InNOut {

  /** Default capacity for the InNOut object */
  private static final int DEFAULT_CAPACITY = 4;

  /** Constants or toString method */
  private static final String SINGULAR_ITEM = "item";
  private static final String PLURAL_ITEMS = "items";

  /** Array to store items */
  private String[] data;

  /** Number of items stored in array. 0 <= size <= data.lenth */
  private int size;

  /** Default constructor */
  public InNOut() {
    this(DEFAULT_CAPACITY);
  } // default constructor;

  /** Basic constructor */
  public InNOut(int capacity) {
    this.data = new String[capacity];
    this.size = 0;
  } // constructor InNOut

  /** Accessor for size */
  public int getSize() {
    return this.size;
  } // method getSize

  /** Accessor for data */
  public String[] getData() {
    return this.data;
  } // method getData

  /** Is the array empty? */
  public boolean isEmpty() {
    return this.size == 0;
  } // method isEmpty

  /** Is the array full? */
  public boolean isFull() {
    return this.size == this.data.length;
  } // method isFull

    public String toString() {
        String itemOrItems = (this.size == 1) ? SINGULAR_ITEM : PLURAL_ITEMS;
            return String.format("Array %s has %d %s stored",
                Arrays.toString(this.data), this.size, itemOrItems);
          }
    /**
   * Add a string to the underlynig array, but place it always at the
   * first position in the array, moving any existing elements as needed
   * to make room.
   *
   * @param item string to add to the array
   * @return true if addition was completed successfully, otherwise false
   */
  public boolean push(String item) {
    // Is there room in the array to add a new item?
    boolean success = (this.size < this.data.length);
    if (success) {
      // Room assured; let's move existing items one place to the right
      for (int i = this.size; i > 0; i--) {
        this.data[i] = this.data[i - 1];
      }
      // Safe to overwrite first item (it has been copied to position [1])
      this.data[0] = item;
      // Adjust size of object
      this.size++;
    }
    return success;
  } // method push


/**
 * Remove and return an item from the beginning of the underlying array. Remaining items are shifted to the front of the array, 
 * and emptying places at the back of the array are filled with nulls.
 * @return the first element in the array if it exists or null if there are no items to remove. 
 */
    public String pop() {
            String removedItem = null;
            //checks to see if the array is empty
            if(this.size > 0) {
                //removes the first item in the array
                removedItem = this.data[0];
                //shifts the array to the left
                for (int i = 1; i < this.size; i++) {
                    this.data[i - 1] = this.data[i];
                }
                //sets the last item in the array to null
                this.data[this.size - 1] = null;
                //update size
                this.size--;
            }
            return removedItem;
        }
        //pop() method
        
/**
 * Take a look at the value of the item in the front of the array, without removing it. If they array is empty, return null.
 * @return the string at beginning of array or null if the array is empty.
 */
    public String peek(){
        //assumes method is empty unless proven otherwise.
        String beg_of_array = null;
        //uses helper isEmpty method
        if(!this.isEmpty()){
            beg_of_array = this.data[0];
        }
        return beg_of_array;
    }
    //peek() method

    
/**
 * Add a string after the last (most recently added) item in the array. 
 * @param string is the string to be appended to the end of the array
 * @return true if there is room and add an element. If the array is full, return false.
 */
    public boolean append(String string) {
        boolean success = false;
        //verifies whether the array is full
        if(!isFull()){
            this.data[this.size] = string;
            this.size++;
            success = true;
        }
        return success;
    }
    //append() method
    
    }

    
    

