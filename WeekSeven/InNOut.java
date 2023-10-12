package WeekSeven;
import java.util.Arrays;

public class InNOut {
    //storage device
    private String [] data;
    
    //default size
    private int DEFAULT_SIZE;

    //basic constructor

    public InNOut(int capacity){
        this.data = new String[capacity];
        this.DEFAULT_SIZE = 0;
    }
    //finds size of the data array
    public int getSize(){
        return this.DEFAULT_SIZE;
    }

    /**
   * Add a string to the underlynig array, but place it always at the
   * first position in the array, moving any existing elements as needed
   * to make room.
   *
   * @param String string to add to the array
   * @return true if addition was completed successfully, otherwise false
   */
    public boolean push(String push){
        boolean success = (this.DEFAULT_SIZE < this.data.length);
        if(success){
            this.compact(this.DEFAULT_SIZE, push);
            success = true;
        }
        return success;
    }
    /**
     * the compact method passes through @param pos (the last position in the array) and string @param ins (string that we're starting at)
     * and reorganizes the array such that all the empty spaces in the array moves all the way to the right. The method starts by varifying
     * wether the position is a good position 
     */
    public void compact(int pos, String ins){
        
            //another double check to make sure position is good 
            if(pos >= 0 && pos < this.DEFAULT_SIZE){
                //insert position x at position x-1. Insert wherever you want into the array.
                //once inserted, the for loop will recompact the array in order to keep everything together
                for(int x = DEFAULT_SIZE; x > pos; x--){
                       this.data[x] = this.data[x-1];
                       
                }
                //when done shifting update parameters.
                this.data[pos] = ins;
                this.DEFAULT_SIZE++;
            }
        }
    public String toString(){
        String ret = "";
        for(int i = 0; i <= this.DEFAULT_SIZE; i++){
            ret = " " + this.data[i];
        }
        return ret;

    }
    }

    
    

