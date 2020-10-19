package Design;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class PeekingIterator<T> implements Iterator {
  public static void main(String[] args) throws IOException {
    List<Integer> list = new ArrayList();
    list.add(1);list.add(2);list.add(3);
    PeekingIterator<Integer> peekingIterator = new PeekingIterator(list.iterator());
    System.out.println(peekingIterator.hasNext());
    System.out.println(peekingIterator.next());
    System.out.println(peekingIterator.peek());
    System.out.println(peekingIterator.peek());
    System.out.println(peekingIterator.next());
    System.out.println(peekingIterator.hasNext());
    System.out.println(peekingIterator.peek());
    System.out.println(peekingIterator.next());
    System.out.println(peekingIterator.hasNext());
  }

    T nextValue;
    Iterator<T> iterator;

    public PeekingIterator(Iterator<T> iterator) {
      this.iterator = iterator;
    }

    public T peek() {
      if (nextValue != null) {
        return nextValue;
      }

      if (iterator.hasNext()) {
        nextValue = iterator.next();
        return nextValue;
      }

      throw new NoSuchElementException();
    }


    @Override
    public boolean hasNext() {
      return nextValue != null || iterator.hasNext();
    }

    @Override
    public T next() {
      if (nextValue != null) {
        T tmp = nextValue;
        nextValue = null;
        return tmp;
      }

      return iterator.next();
    }
}
