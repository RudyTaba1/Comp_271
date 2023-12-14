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
  public static boolean areAnagrams(String first, String second) {
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

  } // method areAnagrams
}