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
     * the compact method passes through @param pos (the last position in the array) and string @param ins (string that we're starting at)
     * and reorganizes the array such that all the empty spaces in the array moves all the way to the right. The method starts by varifying
     * wether the position is a good position 
     */
    public void compact(int pos, String ins){
        
            //another double check to make sure position is good 
            if(pos >= 0 && pos < this.size){
                //insert position x at position x-1. Insert wherever you want into the array.
                //once inserted, the for loop will recompact the array in order to keep everything together
                for(int x = this.size; x > pos; x--){
                       this.data[x] = this.data[x-1];
                       
                }
                //when done shifting update parameters.
                this.data[pos] = ins;
                this.size++;
            }
        }
    public String toString() {
            String itemOrItems = (this.size == 1) ? SINGULAR_ITEM : PLURAL_ITEMS;
            return String.format("Array %s has %d %s stored",
                Arrays.toString(this.data),
                this.size,
                itemOrItems);
          }

          public String pop() {
            String removedItem = null;
            if(this.size > 0) {
                removedItem = this.data[0];
                for (int i = 1; i < this.size; i++) {
                    this.data[i - 1] = this.data[i];
                }
                this.data[this.size - 1] = null;
                this.size--;
            }
            return removedItem;
        }
        

    public String peek(){
        String beg_of_array = null;
        if(!this.isEmpty()){
            beg_of_array = this.data[0];
        }
        return beg_of_array;
    }

    

    public boolean append(String string) {
        boolean success = false;
        if(this.size < this.data.length){
            this.data[this.size] = string;
            this.size++;
            success = true;
        }
        return success;
    }
    
    }

    
    

