import java.util.Arrays;
//only use the .toString() function

public class DynamicArray {
    
    /*Dynamic Array:

     * - resize an array factor of x
     * - how much data
     * - want to retrieve an item via its index position (Random Indexing)
     * - does this item exist in the array?
     * - New data will be added to existing data
     * - Behave as an object
     * - contains a method
     * - Ability to delete data and recompact it
     */

//The Underlying array for our storage
//create class constant for default size of an array
private static final int DEFAULT_SIZE = 2;

//if we have to resize, here's the constant
private static final int RESIZE_FACTOR = 2;

//finds the last elemenet in the array
private int lastElement;

//next avaliable element in the array
private int  nextAvailable;

//Default storage device
private String[] data = new String[DEFAULT_SIZE];

//constructors! 

    //default constructor
    public DynamicArray(){
        this.data = new String[DEFAULT_SIZE];
          this.nextAvailable = 0;
    }
    //constructor if arraysize is less than 1
    public DynamicArray(int arraysize){
        this.data = new String[arraysize];
        if(arraysize<1){
            arraysize = -1 * arraysize;
            this.data = new String[arraysize];
        }
        else{
            this.data = new String[arraysize];
        }
        this.nextAvailable = 0;
    }
    //if given a decimal
    public DynamicArray(double size){
        size = Math.round(size);
        this.data = new String[(int) size];

    }
    /* 9/13/2023: Create a storage method utilizing arrrays */
    //another way of writing the default method
    /*
    public DyanicArray(){
        
        this(DEFAULT_SIZE);
    }
*/
 
 /*
  * The add() method takes a string and adds it to the array by resizing and compacting it
  */
public void add(String add){
   //if the nextAvailable element is equal to the length of the array, then resize the array before adding @param add
    if(this.nextAvailable == this.data.length){
    
    //since method is void, the printf statement let's the user know what's happening
    System.out.printf("\n adding %s to the array %s", add, Arrays.toString(this.data));

    //resize the array 
    this.resize(); 
   }
   //then add @param add to the array
    this.data[this.nextAvailable++] = add;
   
    //Lets the user know what's up
    System.out.printf("\n added %s to array %s", add, Arrays.toString(this.data));
}
//add() method


/**
 * Resize takes creates a new Array called TargetArrays and 
resizes it by multiplying the length of this.data by the RESIZE_FACTOR.
It then takes the data from the data array and puts them into the TargetArray, and then replaces the data array.*/
public void resize()
{
    //setting targetArray = to a size of data * resize factor
    String[] targetArray = new String[RESIZE_FACTOR*this.data.length];
    
    /*for as long as there is something stored in the data array, 
    copy it to the target array. Once the value of i exceeds the length, stop.*/
    for(int i = 0; i<this.data.length; i++){
        //copies elements from data to target array
        targetArray[i] = this.data[i];
    }
    this.data = targetArray;
    //makes data = targetarray, in other words replacing data "copying over to it"
}
//resize method


/**
 * The retrieveContent method retrieves content from an array at a specific index.
 * When retrieved it will return @param recieved.
 * If @param index is an index and an element in the array, then recieved = that element
 * @return recieved
 */
public String retrieveContent(int index){
    //if String is not in method, return null
    String received = null;
    if(index >= 0 && index < this.nextAvailable){
        received = this.data[index];
}
 return received;
}//retrieveContent method

/*remove and return element from object */
private String remove(int index){
    String removed = this.retrieveContent(index);
    if(removed != null){
        //Do something to compact it
        /*this will move the element in the arry one to the right. Thus, it will move the null element to the last element
        in the array*/
        for(int i = index; i < this.nextAvailable; i++){
            this.data[i] = this.data[i+1];
        }
        //will move the "nextAvaliable" to the position the null position.
        this.nextAvailable = this.nextAvailable-1;
        //once all elements have been compacted, the last element in the array will return null
        this.data[nextAvailable] = null;
    }
    return removed;
    //returns the removed word
    //System.out.printf("The word %s has been removed from %s", removed, Array.toString(this.data));
}
//remove method

//method addFront will move @param add to the beginning of the array
public void addFront(String add){
    this.insert(0, add);
    
}

/*
 * method insert() will insert a word at whatever position the user specifies.  
 */
public void insert(int pos, String ins){
    if(ins!=null){
        //if the position is null, and next avaliable is full (the length of the array), then resize before insert
        if(this.nextAvailable == this.data.length){
            this.resize();
        }
        //another double check to make sure position is good 
        if(pos >= 0 && pos < this.nextAvailable){
            //insert position x at position x-1. Insert wherever you want into the array.
            //once inserted, the for loop will recompact the array in order to keep everything together
            for(int x = nextAvailable; x > pos; x--){
                   this.data[x] = this.data[x-1];
                   
            }
            //when done shifting update parameters.
            this.data[pos] = ins;
            this.nextAvailable++;
        }
    }
}
//insert method

/**
 * method counts the amount of words repeated in the array.
 * if @param search is the same as the string in the array at position count, 
 * @return count will return the total amount of repeats found in the array
 */
public int count(String search){
    int count = 0;
    int i =0;
    while(this.data[i].equals(search) && this.data[i]!=null){
        count++;
        i++;
    }
return count;
} 
//count method

/**
 * The addUnique method verifies whether the word passed through is within the array, 
 * and if it is not, will add the String unique to the array.
 */
public void addUnique(String unique){
    
     if(!this.contains(unique)){
    
        this.add(unique);

        }
    }
    //addUnique method


 /**
 * contains will return a boolean determining whether @param serch is within the array.  
 * If it is not @return will return false and vice versa
 */

public boolean contains(String serch){
//The method assumes baseline is false, 
    boolean con = false;
    //the mehod will go through the array
   
    
    //keep getting null pointer exception error, and do not know how to fix it. None of my solutions are working.
    //null means, literally, nothing. Therefore, the code camnot point at nothing. That doesn't work. That being said, clearing the exception is quite difficult.
    //update: did clear it. All code compiles and passes.
    if(serch!=null){
        
        int i = 0;
    
        /*while(i <= this.nextAvailable && this.data[i]!=null)  would be incorrect because obviously next avaliable has nothing in it. 
        We want to figire out whether what is in the existing array is present, not what is in the existing array and what is avaliable. Noted for next time*/
        

        while(i<this.nextAvailable && this.data[i]!=null){
    
        //once the method detects that the element = the serch parameter, it will flip con to true
        if(this.data[i].equals(serch)){
            con = true;
        }

        i++;
        

    }
}
    return con;
}
//contains method

/**
 * indexOf verifies whether or not the @param wordAt is an element within the array. 
 * If it is, @return will return where the element is in the array. If it does not exist in the array,
 * @return will return -1.
 */
public int indexOf(String wordAt){
int pos = 0;
    //if contains returns false, then pos will return -1, which means it is not in the array
    if(this.contains(wordAt)==false){
        pos = -1;

    }
    //if contains returns true, then go through the array until the element in the array = @param wordAt
    if(this.contains(wordAt)==true){
        //for loop sorts through the array
        
        int i = 0;
       /*while(i <= this.nextAvailable && this.data[i]!=null) is incorrect. As noted in the contains() method, 
       we're looking at the existing array. Noted for next time.*/
       
      while(i<this.nextAvailable && this.data[i]!=null){
            //will check if wordAt == data[i]
            if(this.data[i].equals(wordAt)&& this.data[i]!=null){
             //if it is, pos will = i
                pos = i;
            }
        }
    
    }
    
    return pos;
}
/*
 * public int indexOf(string wordAt){
 * pos = -1;
 * int index = 0;
 * while(index < this.nextAvailable && this.data[index]!=null){
 * if(this.data[index].equals(wordAt)){
 * pos = index;
 * index++;
 *}
 * return pos;
 * }
 * 
 * String[] demo = new String[3];
 * demo[0] = "hello";
 * demo[1] = "my";
 * demo[2] = "name";
 * demo[3] = "Rudy";
 * System.out.printf("\n %s \n", this.demo[3]);
 * 
 * return pos;}
 */
//indexOf method

/**
 * method compares two different arrays to see whether or not they are the same.
 * @param other is the other array.
 * @return will return the difference between the total amount of elements in each array.
 */
public int compareTo(DynamicArray other){
    
    return this.size()-other.size();
}
/**
 * accessor method for nextAvaliable
 */
public int getnextAvailable(){
    return this.nextAvailable;
}
/**
 * method size() returns the size of the array
 * @return will return the size of the array
 */
public int size(){
    return this.getnextAvailable()-1;
}
/**
 * toString method will return the contents and the amount of objects in that array.
 * 
 */
public String toString(){
    String sting = String.format("this object has an underlying array with %d elements", this.data.length);
    sting += String.format("\n%d of these elements are used", this.getnextAvailable());
    sting += String.format("\n Contents:");
    for (int i = 0; i < this.nextAvailable; i++){
        sting += String.format("\n %s", this.data[i]);
    }
    return sting;
}
//method toString

}