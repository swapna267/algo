import java.util.function.IntConsumer;

class ZeroEvenOdd {
  private int n;
  private boolean zeroTurn = true;
  private boolean oddTurn = false;
  private boolean evenTurn = false;
  private final Object object = new Object();

  public ZeroEvenOdd(int n) {
    this.n = n;
  }

  // printNumber.accept(x) outputs "x", where x is an integer.
  public void zero(IntConsumer printNumber) throws InterruptedException {
    for (int i=1;i<=n;i++) {
      synchronized(object) {
        while(!zeroTurn) {
          object.wait(10);
        }
        printNumber.accept(0);
        zeroTurn = false;
        if(i%2 == 0) {
          evenTurn = true;
        } else {
          oddTurn = true;
        }
        object.notify();
      }
    }
  }

  public void even(IntConsumer printNumber) throws InterruptedException {
    for (int i=2;i<=n;i+=2) {
      synchronized(object) {
        while(!evenTurn) {
          object.wait(10);
        }
        printNumber.accept(i);
        evenTurn = false;
        zeroTurn = true;
        object.notify();
      }
    }
  }

  public void odd(IntConsumer printNumber) throws InterruptedException {
    for (int i=1;i<=n;i+=2) {
      synchronized(object) {
        while(!oddTurn) {
          object.wait(10);
        }
        printNumber.accept(i);
        oddTurn = false;
        zeroTurn = true;
        object.notify();
      }
    }
  }
}