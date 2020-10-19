import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;


/*
directly using readwritelock
ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
     readWriteLock.readLock().lock();
     readWriteLock.readLock().unLock();
     readWriteLock.writeLock().lock; unlock;

     Lets try implementing read write lock using 2 locks.
 */
public class ReadWriteLockExample {

  public static class ReadWriteLockN implements  ReadWriteLock {
    private Lock readersLock;


    @Override
    public Lock readLock() {
      return null;
    }

    @Override
    public Lock writeLock() {
      return null;
    }
  }

}
