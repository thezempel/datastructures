public class CircularArrayQueueTest {
  public static void queueTest() {
    String first = "abra";
    String second = "ka";
    String third = "dabra";
    CircularArrayQueue queue = new CircularArrayQueue(1);
    System.out.println("testing isEmpty()");
    System.out.println("--------");
    
    System.out.println("initialized queue: size = 1");
    System.out.println("empty = " + queue.isEmpty());
    try{
      System.out.println("front of queue: " + queue.front());
    }
    catch(Exception e) {
      System.out.println("there is nothing in front of queue");
    }
    System.out.println();
    System.out.println("testing enter() while empty");
    System.out.println("--------");
    try {
    queue.enter(first);
    System.out.println("entered successfully");
    }
    catch (Exception e) {
      System.out.println("error");
    }
    System.out.println("front of queue: " + queue.front());
    System.out.println();
    System.out.println("testing enter() with one in queue");
    System.out.println("--------");
    try {
    queue.enter(second);
    System.out.println("entered successfully");
    }
    catch (Exception e) {
      System.out.println("error");
    }
    System.out.println("front of queue: " + queue.front());
    System.out.println("now empty = " + queue.isEmpty());
    System.out.println();
    System.out.println("testing enter() with more than 1 in queue");
    System.out.println("--------");
    try {
    queue.enter(third);
    System.out.println("entered successfully");
    }
    catch (Exception e) {
      System.out.println("error");
    }
    System.out.println("front of queue: " + queue.front());
    System.out.println("now empty = " + queue.isEmpty());
  
    System.out.println();
    System.out.println("testing front() and leave()");
    System.out.println("--------");
    try {
      System.out.println("front of queue = " + queue.front());
    }
    catch (Exception e) {
      System.out.println("error");
    }
    try {
      queue.leave();
      System.out.println("pulled front from queue");
    }
    catch (Exception e) {
      System.out.println("error");
    }
    if (queue.front() == second) {
      System.out.println("front is now: " + queue.front());
      System.out.println("*success*");
    }
    else {
      System.out.println("error -");
      System.out.println("expected: " + second + "\nactual: " + queue.front());
    }
    try {
      queue.leave();
      System.out.println("pulled front from queue");
    }
    catch (Exception e) {
      System.out.println("error");
    }
    if (queue.front() == third) {
      System.out.println("front is now: " + queue.front());
      System.out.println("*success*");
    }
    else {
      System.out.println("error -");
      System.out.println("expected: " + third + "\nactual: " + queue.front());
    }
    System.out.println();
    System.out.println("removing whats left");
    System.out.println("--------");
    queue.leave();
    System.out.println("empty now = " + queue.isEmpty());
    try{
      System.out.println("front is now: " + queue.front());
    }
    catch (Exception e) {
      System.out.println("the queue has nothing in front");
    }
  }
}