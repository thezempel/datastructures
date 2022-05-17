
/**
 * A singly linked list implementation of the Stack interface.
 * Hopefully correctly completed implementation
 *
 * @author Jonathon Zempel
 * @version 2021-07-07
 */

import java.util.EmptyStackException;
import java.util.StringJoiner;

public class LinkedStack<E> implements Stack<E> {
    private class Node {
        public E element;
        public Node next;
        
        public Node(E element) {
            this(element, null);
        }
        
        public Node(E element, Node next) {
            this.element = element;
            this.next = next;
        }
    }
    
    private Node top;

    /**
     * Constructor for objects of class LinkedStack
     */
    public LinkedStack() {
    }

    @Override
    /**
    * Pushes new element onto the stack
    *
    * @param element
    */
    public void push(E element) {
        // Complete this method **
      top = new Node (element, top);
    }
    
    @Override
    /**
    * Removes top element, returns reference to the element
    */
    public E pop() {
        // Complete this method**
        E result;
      try {
        result = top(); 
      }
      catch (NullPointerException e) {
        throw new EmptyStackException();
      }
      top = top.next;
      return result;

    }
    
    @Override
    /**
    * Returns element at top of stack
    */
    public E top() {
      E result;
      try {
        result = top.element; 
      }
      catch (NullPointerException e) {
        throw new EmptyStackException();
      }
      return result;
    }
    
    @Override
    /**
    * Returns true if stack is empty, false otherwise
    */
    public boolean isEmpty() {
    
      return top == null;
    }
    
    @Override
    /**
    * Returns a count of number of elements in the stack
    */
    public int size() {
      int count = 0;
      for (Node current = top; current != null; current = current.next) {
        count++;
      }
      return count;
    }
    
    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "[", "]");
        for (Node current = top; current != null; current = current.next) {
            joiner.add(current.element.toString());
        }
        return joiner.toString();
    }
}
