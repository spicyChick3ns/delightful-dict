/*       Student Information

 *       -------------------
 *       Student Name: Gonzales, Melissa
 *       Lab Section: 02
 *       
 *       I attest that the following code being submitted is my own individual work.
 */
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * This class tests the dictionary class
 *
 */
public class testDictionary {
  static int count = 1; // Corresponds to the line number in input file
  static ArrayList<Integer> key = new ArrayList<Integer>();
  static ArrayList<String> val = new ArrayList<String>();
  static dictionary d1 = new dictionary(key, val);
  // Create 2nd dictionary. Will always remain empty
  static ArrayList<Integer> e1 = new ArrayList<Integer>();
  static ArrayList<String> e2 = new ArrayList<String>();
  static dictionary e3 = new dictionary(e1, e2);

  public static void main(String[] args) throws FileNotFoundException {
    File file = new File("input.txt");
    Scanner inFile = new Scanner(file);
    PrintStream pOut = new PrintStream(new File("output.txt"));
    testDictionary.testInsert(inFile,pOut);
    testDictionary.testGetValue( pOut);
    testDictionary.testGetKey( pOut);
    testDictionary.testRemove( pOut);
    testDictionary.testContains( pOut);
    testDictionary.testCount( pOut);
    testDictionary.testIsEmpty( pOut);
    testDictionary.testPrintKeys( pOut);
    testDictionary.testCompare( pOut);
  }

  // This function tests the insert function in class dictionary
  // Ensures the correct values are inserted
  //If could not add to dictionary, test case shows fail
  public static void testInsert(Scanner inFile, PrintStream pOut) {
    pOut.println("Entering testInsert...");
    pOut.println("If could not add to dictionary, test case shows fail!!");

    while (inFile.hasNextLine()) {
      if (count >= 27) {
        d1.printDict();
        pOut.println("Exiting testInsert ...");
        break;
      }
      String cur = inFile.next();
      String[] point = cur.split(",");
      int x = Integer.parseInt(point[0]);
      String s = point[1];
      d1.Insert(x, s);
      if (d1.Contains(x))
        pOut.println("Test case " + count + " passed.");
      else
        pOut.println("Test case " + count + " failed.");
      count++;
    }
  }

  // This function tests the getValue function in class dictionary
  // Ensures the correct values are returned
  // getkey returns null if value DNE/empty dictionary, returns a string
  // otherwise
  public static void testGetValue(PrintStream pOut) {
    pOut.println("Entering getValue...");
    if (d1.GetValue(0).equals("'kool'"))
      pOut.println("Test case " + count + " Pass.");
    else
      pOut.println("Test case " + count + " failed.");
    count++;
    if (d1.GetValue(989898) == null)
      pOut.println("Test case " + count + " passed.");
    else
      pOut.println("Test case " + count + " failed.");
    count++;
    pOut.println("Exiting testGetValue...");

  }

  // This function tests the getKey function in class dictionary
  // Ensures the correct values are returned
  // getkey returns null if value DNE/empty dictionary, returns a string
  // otherwise
  public static void testGetKey(PrintStream pOut) {
    pOut.println("Entering getKey...");
    // Test for value in empty dictionary
    if (e3.GetKey("'sweet'") == null)
      pOut.println("Test case " + count + " passed.");
    else
      pOut.println("Test case " + count + " failed.");
    count++;
    // Test for value not in the dictionary
    if (d1.GetKey("'arms'") == null)
      pOut.println("Test case " + count + " pass.");
    else
      pOut.println("Test case " + count + " fail.");
    count++;
    /*
    if (d1.GetKey("kool").equals("[0, 17, ]"))
      pOut.println("Test case " + count + " passed.");
    else
      pOut.println("Test case " + count + " failed.");
    count++;
    */
    pOut.println("Exiting testGetKey...");

  }

  // This function tests the remove function in class dictionary
  // Ensures the correct values are returned
  public static void testRemove(PrintStream pOut) {
    pOut.println("Entering testRemove...");
    if (d1.Remove(0) == 0)
      pOut.println("Test case " + count + " passed.");
    else
      pOut.println("Test case " + count + " failed.");
    count++;
    d1.Insert(0, "'kool'");
    if (d1.Remove(19) == 0)
      pOut.println("Test case " + count + " passed.");
    else
      pOut.println("Test case " + count + " failed.");
    count++;
    d1.Insert(19, "'a'");
    // Test remove function on empty dictionary
    if (e3.Remove(1) == -1)
      pOut.println("Test case " + count + " pass.");
    else
      pOut.println("Test case " + count + " fail.");
    count++;
    pOut.println("Exiting testRemove...");
  }

  // This function tests the contain function in class dictionary
  // Ensures that the function contains a given key (integer)
  public static void testContains(PrintStream pOut) {
    pOut.println("Entering testContains...");
    if (d1.Contains(9) == true)
      pOut.println("Test case " + count + " passed");
    else
      pOut.println("Test case " + count + " failed");
    count++;
    if (d1.Contains(10000) == true)
      pOut.println("Test case " + count + " failed");
    else
      pOut.println("Test case " + count + " passed");
    count++;
    pOut.println("Exiting testContains...");

  }

  // This function tests the count function in class dictionary
  // Ensures that the function returns a proper size of the dictionary
  public static void testCount(PrintStream pOut) {
    pOut.println("Entering testCount...");
    if (d1.Count() == 20)
      pOut.println("Test case " + count + " passed");
    else
      pOut.println("Test case " + count + " failed");
    count++;
    d1.Remove(11);
    d1.Remove(1);
    d1.Remove(0);
    if (d1.Count() == 17)
      pOut.println("Test case " + count + " passed");
    else
      pOut.println("Test case " + count + " failed");
    count++;
    pOut.println("Exiting testCount...");
    d1.Insert(11, "'great'");
    d1.Insert(1, "'a'");
    d1.Insert(0, "'kool'");
  }

  // This function tests the isEmpty function in class dictionary
  // Ensures that the function returns a proper boolean value. True if empty,
  // false if not
  public static void testIsEmpty(PrintStream pOut) {
    pOut.println("Entering testIsEmpty...");
    if (d1.isEmpty() == false)
      pOut.println("Test case " + count + " passed");
    else
      pOut.println("Test case " + count + " failed");
    count++;
    if (e3.isEmpty() == true)
      pOut.println("Test case " + count + " passed");
    else
      pOut.println("Test case " + count + " failed");
    count++;
    pOut.println("Exiting testContains...");
  }

  // This function tests the PrintKeys function in class dictionary
  // Ensures that the function returns a proper string of keys that have the
  // same value
  public static void testPrintKeys(PrintStream pOut) {
    pOut.println("Entering testPrintKeys...");
    if (d1.printKeys().equals("{2, 4, 5, 6, 7, 8, 9, 10, 12, 13, 14, 15, 16, 17, 18, 20, 19, 11, 1, 0}"))
      pOut.println("Test case " + count + " passed");
    else
      pOut.println("Test case " + count + " failed");
    count++;
    // Test on empty dictionary
    if (e3.printKeys() == null)
      pOut.println("Test case " + count + " passed");
    else
      pOut.println("Test case " + count + " failed");
    count++;
    pOut.println("Exiting testPrintKeys...");
  }
  // This function tests the compare function in class dictionary
  // Ensures that the function returns a proper boolean value
  public static void testCompare(PrintStream pOut) {
    pOut.println("Entering testCompare...");
    if (d1.Compare(654654, 68789879) == false)
      pOut.println("Test case " + count + " passed");
    else
      pOut.println("Test case " + count + " failed");
    count++;
    if (e3.Compare(7897897, 7897) == false)
      pOut.println("Test case " + count + " passed");
    else
      pOut.println("Test case " + count + " failed");
    count++;
    if (d1.Compare(1, 13) == true)
      pOut.println("Test case " + count + " passed");
    else
      pOut.println("Test case " + count + " failed");
    count++;
    pOut.println("Exiting testCompare...");
  }
}
