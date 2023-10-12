
/**
 *  DO NOT MODIFY THIS CLASS/
 *  Naive testing class for DynamicArray
 */
class TestDynamicArray {
  private static final int A = (int) 'A';
  private static final int Z = (int) 'Z';
  private static final String CONTAINS_TEXT = "Test result for method contains: ";
  private static final String INDEXOF_TEXT = "Test result for method indexOf: ";
  private static final String PASS = "PASS";
  private static final String FAIL = "FAIL";
  
  public static void testDynamicArray() {
    DynamicArray demo = new DynamicArray();
    for (int __ = A; __ <= Z; __++) {
      demo.add(String.valueOf((char)__));
    }
    boolean test1 = demo.contains(String.valueOf((char)A));
    boolean test2 = demo.contains(String.valueOf((char)(A+Z)));
    boolean test3 = demo.contains(null);
    String containsTest = (test1 && !test2 && !test3) ? PASS : FAIL;
    System.out.printf("\n\n%s%s\n", CONTAINS_TEXT, containsTest);
    boolean test4 = true;
    for (int __ = A; __ <= Z; __++) {
      test4 = test4 && (__-A) == demo.indexOf(String.valueOf((char)__));
    }
    boolean test5 = -1 == demo.indexOf(String.valueOf((char)(A+Z)));
    String indexOfTest = (test4 & test5) ? PASS : FAIL;
    System.out.printf("\n%s%s\n\n", INDEXOF_TEXT, indexOfTest);
  } // method testDynamicArray
} // class TestDynamicArray