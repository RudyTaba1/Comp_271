package FinalExam;

public class Anagrams {

  /**
   * Determine if two strings are anagrams of each other. Assume that
   * the strings contain only valid letters. Letter-case is not important,
   * for example, "BAT" and "Tab" are still anagrams.
   *
   * @param first  String one of the two strings to compare
   * @param second String the other of the two strings to compare
   * @return true if first and second strings are anagrams of eachother,
   *         false otherwise or if either string is null
   */

   //SOLUTION:

   private static final int LETTERS_IN_ALPHABET = 26;


   public static boolean areAnagrams(String first, String second) {
    // This is a guard statement that can justify an extra return false 
    boolean theyAre = first != null && second != null && first.length() == second.length();
    // If block below executes if input strings are legit
    if (theyAre) {
      // Set up a counter for every letter in the alphabet
      int[] letterCount = new int[LETTERS_IN_ALPHABET];
      for (int index = 0; index < first.length(); index++) {
        // Increase corresponding counter if letter appears in first string
        int fromFirst = (int) first.toUpperCase().charAt(index) - (int) 'A';
        letterCount[fromFirst] += 1;
        // Decrease corresponding counter if letter appears in first string
        int fromSecond = (int) second.toUpperCase().charAt(index) - (int) 'A';
        letterCount[fromSecond] -= 1;
      }
      // Traverse the counter array; stop as soon as non zero is found
      int i = 0;
      while (i<letterCount.length && theyAre) {
        theyAre = letterCount[i++] == 0;
      }
    }
    return theyAre;
  } // method areAnagrams
  
  //STUDENT ANSWER:
  /*public static boolean areAnagrams(String first, String second) {
    boolean theyAre = true; 

    //converts both strings to lowercase
    first = first.toLowerCase();
    second = second.toLowerCase();

    //arrays for each string
    int[] firstArray = new int[26];
    int[] secondArray = new int[26];

    if (first.length() == second.length()) {
        // Count how often each character shows up in each string
        for (int i = 0; i < first.length(); i++) {
            firstArray[first.charAt(i) - 'a']++;
            secondArray[second.charAt(i) - 'a']++;
        }

        // how often the same character shows in both strings
        for (int j = 0; j < 26; j++) {
            if (firstArray[j] != secondArray[j]) {
                theyAre = false; 
                 
            }
        }
    } else {
        theyAre = false; 
        // different lengths, can't be anagrams
    }

    return theyAre;

  } // method areAnagrams*/
}