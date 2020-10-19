package Design;

import javafx.util.Pair;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class LoggerRateLimiter {
  Map<Long,Long> map = new HashMap();
  ReadWriteLock lock = new ReentrantReadWriteLock();
  Deque<Pair<Long,Long>> queue = new ArrayDeque<>();
  ScheduledExecutorService scheduledExecutorService;

  public LoggerRateLimiter() {
    scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
    scheduledExecutorService.schedule(new CleanupTask(), 1, TimeUnit.SECONDS);
  }

  public boolean shouldLog(long id, long timestamp) {
    // map contains => false
    // add tomap and add to list
    //Readlock
    //checkexists , if exists false
    // Writelock
    // check again
    //
    try {
      lock.readLock().lock();
      if (map.containsKey(id)) {
        return false;
      }
    } finally {
      lock.readLock().unlock();
    }


     try {
       lock.writeLock().lock();
       if (map.containsKey(id)) {
         return false;
       }

       map.put(id, timestamp);
       queue.add(new Pair<>(id,timestamp));
       return true;
     } finally {
        lock.writeLock().unlock();
     }
  }

  public static void main(String[] args) {

  }

  public class CleanupTask implements Runnable {

    @Override
    public void run() {
      try {
        long timestamp = System.currentTimeMillis();
        lock.writeLock().lock();
        Pair<Long,Long> curr = queue.peek();
        while (curr.getValue() < timestamp-10*1000) {
          queue.poll();
          map.remove(curr.getKey(), curr.getValue());
          curr = queue.peek();
        }
      } finally {
         lock.writeLock().unlock();
      }
    }
  }
}
