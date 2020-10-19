import java.util.concurrent.atomic.AtomicBoolean;

public class OddEvenThreads {

  public static void main(String[] args) throws InterruptedException {
    AtomicBoolean oddTurn = new AtomicBoolean(true);
    AtomicBoolean evenTurn = new AtomicBoolean(false);

    NumberPrinter oddPrinter = new NumberPrinter(oddTurn, evenTurn, true);
    NumberPrinter evenPrinter = new NumberPrinter(oddTurn, evenTurn, false);

    Thread evenThread = new Thread(evenPrinter);
    evenThread.start();
    Thread oddThread = new Thread(oddPrinter);
    oddThread.start();

    oddThread.join();
    evenThread.join();
  }

  static class NumberPrinter implements  Runnable {
    private AtomicBoolean oddTurn;
    private AtomicBoolean evenTurn;
    private boolean isOdd;

    public NumberPrinter(AtomicBoolean oddTurn, AtomicBoolean evenTurn, boolean isOdd) {
      this.oddTurn = oddTurn;
      this.evenTurn = evenTurn;
      this.isOdd = isOdd;
    }

    public void run() {
      if (isOdd) {
        for (int i = 1; i < 100; i += 2) {
        //  while (true) {
            if (oddTurn.getAndSet(false)) {
              System.out.println(i);
              evenTurn.set(true);
              try {
                Thread.sleep(100);
              } catch (InterruptedException e) {
                e.printStackTrace();
              }
              try {
                notifyAll();
                wait();
              } catch (InterruptedException e) {
                e.printStackTrace();
              }
                 }
        //  }
        }
      } else {
        for (int i = 2; i <= 100; i += 2) {
          while (true) {
            if (evenTurn.getAndSet(false)) {
              System.out.println(i);
              oddTurn.set(true);
              break;
            }
          }
        }

      }

    }
  }
}
