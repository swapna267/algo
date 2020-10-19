
  import java.util.concurrent.Semaphore;

  class FooBarPrinter {
    private int n;
    private final Semaphore foo = new Semaphore(1);
    private final Semaphore bar = new Semaphore(0);

    public FooBarPrinter(int n) {
      this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

      for (int i = 0; i < n;i++) {
        foo.acquire();
        printFoo.run();
        bar.release();
      }

    }

    public void bar(Runnable printBar) throws InterruptedException {
      for (int i = 0; i < n;i++) {
        bar.acquire();
        printBar.run();
        foo.release();


      }
    }
  }

