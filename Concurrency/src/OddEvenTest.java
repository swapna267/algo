import java.util.concurrent.atomic.AtomicBoolean;
//Boolean and String are immutable objects


public class OddEvenTest {

  public static void main(String[] args) throws InterruptedException {
    AtomicBoolean oddTurn = new AtomicBoolean(true);
    Object lock = new Object();
    OddPrinter oddPrinter = new OddPrinter(oddTurn, lock);
    EvenPrinter evenPrinter = new EvenPrinter(oddTurn, lock);
    Thread t1 = new Thread(oddPrinter);
    Thread t2 = new Thread(evenPrinter);
    t1.start();
    t2.start();
    t1.join();
    t2.join();
  }

    static class OddPrinter implements Runnable {
      private AtomicBoolean isOddTurn;
      private Object lock;
      int counter = 1;

      public OddPrinter(AtomicBoolean isOddTurn, Object lock) {

        this.isOddTurn = isOddTurn;
        this.lock = lock;
      }

      @Override
      public void run() {
        try {
          while(counter <= 100) {
            synchronized (lock) {
              System.out.println(counter);
              counter+=2;
              isOddTurn.set(false);
              lock.notifyAll();
              while(!isOddTurn.get()) {
                lock.wait();
              }
            }
          }

        } catch (InterruptedException e) {

        }

      }
    }

    static class EvenPrinter implements Runnable {
      private AtomicBoolean isOddTurn;
      private Object lock;
      int counter = 2;

      public EvenPrinter(AtomicBoolean isOddTurn, Object lock) {
        this.isOddTurn = isOddTurn;
        this.lock = lock;
      }


      @Override
      public void run() {
        try {
          while (counter <= 100) {
            synchronized (lock) {
              while(isOddTurn.get()) {
                lock.wait();
              }

              System.out.println(counter);
              counter+=2;
              isOddTurn.set(true);
              lock.notifyAll();
            }

          }

        } catch (InterruptedException e) {

        }
      }
      }
    }


