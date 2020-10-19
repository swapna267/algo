import jdk.nashorn.internal.codegen.CompilerConstants;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FederationServiceExample {
  // async clients talking to multiple services , read responses and merge them.
  // Make the Merging thread nonblocking


  public static void main(String[] args) throws Exception {
    Service1 service1 = new Service1();
    ExecutorService service = Executors.newFixedThreadPool(10);
    Future<String> f1 = service.submit(service1);


  }


  public static String test() {
      return "1";
  }

  static class Service1 implements Callable {

    @Override
    public String call() throws Exception {
      Thread.sleep(10000);
      return "blahblah";
    }
  }

  static class Service2 implements Callable {

    @Override
    public String call() throws Exception {
      Thread.sleep(10005);
      return "blahblah2";
    }
  }
}
