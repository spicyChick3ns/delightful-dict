
/*       Student Information
 *       -------------------
 *       Student Name: Gonzales, Melissa
 *       Student Number: 400018207
 *       Course Code: CS/SE 2XB3
 *       Lab Section: 02
 *       
 *       I attest that the following code being submitted is my own individual work.
 */
import java.util.ArrayList;

public class dictionary {
  private ArrayList<Integer> key = new ArrayList<Integer>();
  private ArrayList<String> value = new ArrayList<String>();

  dictionary(ArrayList key, ArrayList value) {
    this.key = key;
    this.value = value;
  }

  public void Insert(int key, String value) {
    for (int x : this.key) {
      if (x == key) {
        System.out.println("Keys are unique, and only appear once within the dictionary!");
        break;
      }
    }
    if (this.key.size() >= 20) {
      System.out.println("Dictionary full. Maximum limit of 20 elements!");
    } else {
      this.key.add(key);
      this.value.add(value);
    }
  }

  // This function returns the value of a given key
  public String GetValue(int key) {
    int index = 0;
    if (isEmpty() == true)
      return null;
    else if (Contains(key) == false)
      return null;
    else {
      for (int x : this.key) {
        if (x == key) {
          break;
        }
        index++;
      }
      return this.value.get(index);
    }
  }

  // This function returns all keys of the given value */
  // Returns null if dictionary is empty / no existing value in dictionary
  public String GetKey(String value) {
    int count = 0;
    String s = "[";
    while (true) {
      if (isEmpty() == true) {
        System.out.println("Dictionary is empty! No key to get!");
        return null;
      } else if (ContainsVal(value) == false) {
        System.out.println("No existing value in dictionary!");
        return null;
      } else {
        for (String x : this.value) {
          if (x == value) {
            int i = this.key.get(count);
            s = s.concat(Integer.toString(i));
            s = s.concat(", ");
          }
          count++;
        }
        s = s.concat("]");
        return s;
      }
    }
  }

  // This function removes a (key,value) in a dictionary given a key
  // Returns -1 if the dictionary is empty/DNE in dictionary
  // Returns 0 if remove is successful
  public int Remove(int key) {
    int index = 0;
    while (true) {
      if (isEmpty() == true) {
        System.out.println("Nothing to remove! Dictionary is empty!");
        return -1;
      } else if (Contains(key) == false) {
        System.out.println("Nothing to remove! Key is not in dictionary!");
        return -1;
      } else {
        for (int x : this.key) {
          if (x == key) {
            this.key.remove(index);
            this.value.remove(index);
            return 0;
          }
          index++;
        }
      }
    }
  }

  public boolean Compare(int p, int q) {
    if (isEmpty() == true)
      return false;
    String v1 = GetValue(p);
    String v2 = GetValue(q);
    if (v1 == null)
      return false;
    else if (v2 == null)
      return false;
    if (v1.equals(v2)) {
      return true;
    } else if (p == q) {
      return true;
    } else {
      return false;
    }
  }

  public boolean Contains(int k) {
    if (isEmpty() == true)
      return false;
    for (int x : this.key) {
      if (x == k)
        return true;
    }
    return false;
  }

  public boolean ContainsVal(String v) {
    if (isEmpty() == true)
      return false;
    for (String i : this.value) {
      if (i.equals(v))
        return true;
    }
    return false;
  }

  public boolean isEmpty() {
    return this.key.isEmpty();
  }

  public int Count() {
    return this.key.size();
  }

  public String printKeys() {
    int count = 0;
    String s = "";
    if (isEmpty() == true) {
      printEmpty();
      return null;
    }
    System.out.print("{");
    s = s.concat("{");
    for (int x : this.key) {
      System.out.print(x);
      s = s.concat(Integer.toString(x));
      if (!(count == (this.key.size() - 1))) {
        System.out.print(", ");
        s = s.concat(", ");
        count++;
      } else {
        System.out.print("}");
        s = s.concat("}");
        return s;
      }
    }
    return s;
  }

  //Function prints out my dictionary
  public void printDict() {
    int count = 0;
    if (isEmpty() == true)
      printEmpty();
    System.out.print("{");
    for (int x : this.key) {
      System.out.print(x + ": " + GetValue(x));
      if (!(count == (this.key.size() - 1))) {
        System.out.print(", ");
        count++;
      } else {
        System.out.print("}");
        System.out.print("\n");
        break;
      }
    }
  }

  public String printEmpty() {
    while (true) {
      if (isEmpty() == true) {
        System.out.println("{}");
        return null;
      }
    }
  }
}