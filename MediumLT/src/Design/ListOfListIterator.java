package Design;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

// List of List of Integers
//[1,[4,[6]]]
public class ListOfListIterator implements Iterator {
  private Iterator<Object> currListItr;
  private Integer currentVal;
  private ListOfListIterator child;

  public ListOfListIterator(List list) {
    currListItr = list.iterator();
  }


  @Override
  public boolean hasNext() {
    if (currentVal != null || (child!=null && child.hasNext())) {
      return true;
    }

    if (currListItr.hasNext()) {
      Object val = currListItr.next();
      if (val instanceof Integer) {
        currentVal = (Integer) val;
        return true;
      }

      child = new ListOfListIterator((List)val);
      return hasNext();
    }

    return false;
  }

  @Override
  public Object next() {
    if (hasNext()) {
      if (currentVal != null) {
        Integer temp = currentVal;
        currentVal = null;
        return temp;
      }

      return child.next();
    }

    throw new NoSuchElementException();
  }

  public static void main(String[] args) {
    List list = new ArrayList();
    list.add(1);
    list.add(new ArrayList<>());
    list.add(new ArrayList<>());
    List t = new ArrayList();
    t.add(2);
    t.add(3);
    list.add(t);

    list.add(4);
    ListOfListIterator listOfListIterator = new ListOfListIterator(list);
   // while (listOfListIterator.hasNext()) {
    listOfListIterator.hasNext();
      System.out.println(listOfListIterator.next());
    System.out.println(listOfListIterator.next());
    System.out.println(listOfListIterator.next());
    System.out.println(listOfListIterator.next());
    //}
  }
}
