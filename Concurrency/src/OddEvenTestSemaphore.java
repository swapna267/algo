import java.util.concurrent.Semaphore;

public class OddEvenTestSemaphore {

  public static void main(String[] args) throws InterruptedException {
    Printer printer = new Printer();
    PrinterRunnable oddPrinter = new PrinterRunnable(printer,true);
    PrinterRunnable evenPrinter = new PrinterRunnable(printer,false);
    Thread t1 = new Thread(oddPrinter);
    Thread t2 = new Thread(evenPrinter);
    t1.start();
    t2.start();
    t1.join();
    t2.join();
  }

  static class PrinterRunnable implements  Runnable {
    Printer printer;
    private boolean isOdd;

    public PrinterRunnable(Printer printer, boolean isOdd) {
      this.printer = printer;
      this.isOdd = isOdd;
    }

    @Override
    public void run() {
      try {
        if (isOdd) {
          printer.printOdd();
        } else {
          printer.printEven();
        }
      } catch (InterruptedException e) {

      }

    }
  }

  static class Printer {
    Semaphore oddSemaphore = new Semaphore(1);
    Semaphore evenSemaphore = new Semaphore(0);

    public void printEven() throws InterruptedException {
      int i = 2;
      while(i<=100) {
        evenSemaphore.acquire();
        System.out.println(i);
        i+=2;
        oddSemaphore.release();
      }
    }

    public void printOdd() throws InterruptedException {
      int i = 1;
      while(i<=100) {
        oddSemaphore.acquire();
        System.out.println(i);
        i+=2;
        evenSemaphore.release();
      }

    }
  }

}
