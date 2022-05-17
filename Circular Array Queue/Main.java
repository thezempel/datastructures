public class Main {
  public static void main(String[] args) {
    CircularArrayQueue myQueue = new CircularArrayQueue();
    myQueue.enter(8);
    System.out.println(myQueue.toString());
    myQueue.enter(6);
    System.out.println(myQueue.toString());
    myQueue.leave();
    System.out.println(myQueue.toString());
    myQueue.enter(3);
    System.out.println(myQueue.toString());
    myQueue.enter(4);
    System.out.println(myQueue.toString());
    myQueue.enter(15);
    System.out.println(myQueue.toString());
    myQueue.enter(12);
    System.out.println(myQueue.toString());
    myQueue.enter(9);
    System.out.println(myQueue.toString());
    myQueue.leave();
    System.out.println(myQueue.toString());
    myQueue.leave();
    System.out.println(myQueue.toString());
    myQueue.leave();
    System.out.println(myQueue.toString());
    myQueue.enter(19);
    System.out.println(myQueue.toString());
    System.out.println(myQueue.toString());
  }
}