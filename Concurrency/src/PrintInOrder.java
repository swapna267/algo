import java.util.concurrent.CountDownLatch;

public class PrintInOrder {

  public static void main(String[] args) throws InterruptedException {
    Foo foo = new Foo();
    Thread t1 = new Thread(new FirstRunnable(foo));
    t1.start();
    Thread t3 = new Thread(new ThirdRunnable(foo));
    t3.start();
    Thread t2 = new Thread(new SecondRunnable(foo));
    t2.start();


    t1.join();
    t2.join();
    t3.join();
  }

  static class FirstRunnable implements Runnable {
    Foo f;

    public FirstRunnable(Foo f) {
      this.f = f;
    }

    @Override
    public void run() {
      try {
        Thread.sleep(1000);
        f.first(new StringRunnable("First"));
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  static class SecondRunnable implements Runnable {
    Foo f;

    public SecondRunnable(Foo f) {
      this.f = f;
    }

    @Override
    public void run() {
      try {
        f.second(new StringRunnable("Second"));
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  static class ThirdRunnable implements Runnable {
    Foo f;

    public ThirdRunnable(Foo f) {
      this.f = f;
    }

    @Override
    public void run() {
      try {
        f.third(new StringRunnable("Third"));
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  static class StringRunnable implements Runnable {
    String s;

    public StringRunnable(String s) {
      this.s = s;
    }

    @Override
    public void run() {
      System.out.println(s);
    }
  }

  static class Foo {
    private final CountDownLatch firstLatch;
    private final CountDownLatch secondLatch;

    public Foo() {
      firstLatch = new CountDownLatch(1);
      secondLatch = new CountDownLatch(1);
    }

    public void first(Runnable printFirst) throws InterruptedException {

      // printFirst.run() outputs "first". Do not change or remove this line.
      printFirst.run();
      firstLatch.countDown();
    }

    public void second(Runnable printSecond) throws InterruptedException {
      firstLatch.await();

      // printSecond.run() outputs "second". Do not change or remove this line.
      printSecond.run();
      secondLatch.countDown();
    }

    public void third(Runnable printThird) throws InterruptedException {
      secondLatch.await();
      // printThird.run() outputs "third". Do not change or remove this line.
      printThird.run();
    }
  }


}
