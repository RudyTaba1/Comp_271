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
    boolean theyAre = false;
    first = first.toLowerCase();
    second = second.toLowerCase();
    if(first.length() == second.length()){
      for(int i = 0; i < first.length(); i++){
        if(/*second.indexOf(first.charAt(i)) < 0*/ first.charAt(i) != second.charAt(i)){
          return theyAre;
        }
      }
      theyAre = true;
    }
    return theyAre;
  } // method areAnagrams
}