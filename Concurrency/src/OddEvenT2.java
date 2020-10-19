import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class OddEvenT2 {



  public class PrintThread implements Runnable {

    private AtomicInteger integer;
    private Lock lock;

    public void PrintThread(AtomicInteger integer, Lock lock) {
      this.integer = integer;
      this.lock = lock;
    }


    @Override
    public void run() {
      lock.lock();
      System.out.println(integer.getAndIncrement());
      lock.unlock();
      AtomicBoolean b = new AtomicBoolean();
      Lock lock = new ReentrantLock();
    }
  }
}
