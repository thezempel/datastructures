import java.util.NoSuchElementException;
import java.util.StringJoiner;

/**
 * A queue implemented using a circular buffer.
 *
 * @author  Jonathon Zempel
 * @version 2021-07-13
 */
public class CircularArrayQueue<E> implements Queue<E> {
  public static final int DEFAULT_CAPACITY = 100;
  private int front; // Index of the front cell of the queue
  private int rear; // Index of the next available cell of the queue
  private E[] queue; // Circular buffer

  public CircularArrayQueue(int initialCapacity) {
    queue = (E[]) new Object[initialCapacity];
    front = 0;
    rear = 0;
  }

  public CircularArrayQueue() {
    this(DEFAULT_CAPACITY);
  }
    
  @Override
  public void enter(E element) {
    // inserts an element into the rear of the queue
    if(isFull()) {
      expandCapacity();
    }
    
    //System.out.println("rear now " + rear);
    queue[rear] = element;
    rear = (rear + 1) % queue.length; 
    
    
    
  }

  @Override
  public E leave() throws NoSuchElementException {
    //basically pop
    if (isEmpty())
      throw new NoSuchElementException("nothing there");
    E temp = queue[front];
    
    front = (front + 1) % queue.length;
    return temp;
    
  }

  @Override
  public E front() throws NoSuchElementException {
    // returns element at front
    //System.out.println("front is " + front);
    if (isEmpty())
      throw new NoSuchElementException("nothing there");
    return queue[front];
  }
    
  @Override
  public boolean isEmpty() {
    // returns true if there are no elements in the queue, false otherwise
    return (front == rear);
  }
    
  private boolean isFull() {
    // returns true if queue is full, false otherwise
    return (front == ((rear + 1) % queue.length ));
  }

  private int incrementIndex(int index) {
    return (index + 1) % queue.length;
  }
    
  private void expandCapacity() {
    // Implement as part of assignment
  E[] larger = (E[]) new Object[queue.length * 2];
  for (int i = 0; i < queue.length; i++) {
    larger[i] = queue[front];
    front = (front + 1) % queue.length;
  } 
  queue = larger;
  //System.out.println("length " +queue.length);
  }
    
  @Override
  public String toString() {
    StringJoiner result = new StringJoiner("[", ", ", "]");
    for (int i = front; i != rear; i = incrementIndex(i)) {
      result.add(queue[i].toString());
    }
    return result.toString();
  }
}
