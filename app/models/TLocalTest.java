package models;

import java.util.concurrent.atomic.*;
import play.api.*;

// We need to scatter write to this redis
public class TLocalTest {
  public static final TLocalTest SINGLETON = new TLocalTest();

  private static final AtomicInteger COUNT = new AtomicInteger();

  private TLocalTest() {
    //singleton
  }

  private ThreadLocal<String> memoryLeak = new ThreadLocal<String>() {
    protected String initialValue() {
      int current = COUNT.incrementAndGet();
      System.out.println( "Got to " + current );
      return "This causes a memory leak : " + current;
    }
  };

  public String op() {
    return memoryLeak.get();
  }
}
