package WeekSeven;
public class SearchingAndSorting {

    public static void main(String[] args){
        int [] array = {10, 9, 8, 2}; //trainsform {2, 8, 9, 10}
        //find the smallest number
        //compare? 
    }
    public int[] naiveSort(int[] array){
        
        for(int pos = 0; pos < array.length; pos++){
            int index_smallst = pos;
            int smallest = array[index_smallst];
            for(int i = pos+1; i < array.length; i++){
                if(array[i] < smallest){
                    smallest = array[i];
                    pos = i;
                }
            }
        }
        return array;
    }
}
