import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class CountDownLatchExample {

  //1 producer, 2 consumer, use latch to communicate producer done with producing

  public static void main(String[] args) {
    ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<String>(10);
    CountDownLatch latch = new CountDownLatch(2);
    ExecutorService service = Executors.newFixedThreadPool(2);
    Producer producer = new Producer(latch, queue);
    service.submit(producer);
    service.submit(producer);
    Consumer consumer = new Consumer(latch, queue);
    ExecutorService consumerService = Executors.newFixedThreadPool(2);
    consumerService.submit(consumer);
    consumerService.submit(consumer);

    service.shutdown();
    consumerService.shutdown();
  }

  static class Producer implements  Runnable {
    private CountDownLatch latch;
    private ArrayBlockingQueue queue;
    private AtomicInteger producerId = new AtomicInteger();


    public Producer(CountDownLatch latch, ArrayBlockingQueue<String> queue) {
      this.latch = latch;
      this.queue = queue;
    }

    @Override
    public void run() {
      int id = producerId.incrementAndGet();
      for (int i=0;i<100;i++) {
        try {
          queue.put(id+":"+i);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }

      System.out.print("Producer:"+id+" Exiting");
      latch.countDown();
    }
  }

  static  class Consumer implements Runnable {
    private CountDownLatch latch;
    private ArrayBlockingQueue<String> queue;
    private AtomicInteger consumerId = new AtomicInteger();

    public Consumer(CountDownLatch latch, ArrayBlockingQueue<String> queue) {
      this.latch = latch;
      this.queue = queue;
    }

    @Override
    public void run() {
      int id = consumerId.incrementAndGet();
      try {
        String data;
        while (true) {
          data = queue.poll(100, TimeUnit.MILLISECONDS);
          if (data != null) {
            System.out.println("Consuming the data:" + data);
            continue;
          }

          if(latch.await(100, TimeUnit.MILLISECONDS)) {
            while((data = queue.poll()) != null) {
              System.out.println("Consumer:"+id+"Consuming the data:" + data);
            }
            break;
          }

        }
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

      System.out.print("Consumer:"+id+" Exiting");
    }
  }
}
