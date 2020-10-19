class FooBarPrinter2 {
  private int n;
  private boolean fooTurn = true;
  private final Object object = new Object();

  public FooBarPrinter2(int n) {
    this.n = n;
  }

  public void foo(Runnable printFoo) throws InterruptedException {

    for (int i = 0; i < n;i++) {
      synchronized(object) {
        while(!fooTurn) {
          object.wait(1);
        }
        printFoo.run();
        fooTurn = false;
        object.notify();
      }
    }

  }

  public void bar(Runnable printBar) throws InterruptedException {
    for (int i = 0; i < n;i++) {
      synchronized(object) {
        while(fooTurn) {
          object.wait(1);
        }
        printBar.run();
        fooTurn = true;
        object.notify();
      }
    }
  }
}