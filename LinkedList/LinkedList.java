import java.util.NoSuchElementException;
import java.util.StringJoiner;

/**
 * LinkedList represents a linked implementation of a list.
 * 
 * @author Java Foundations / Tim Harrison / Jonathon Zempel
 * @version 2021-07-23
 */
public abstract class LinkedList<E> implements List<E> {
    protected class Node {
        E element;
        Node next;

        Node(E element) {
            this(element, null);
        }

        Node(E element, Node next) {
            this.element = element;
            this.next = next;
        }
    }

    protected int count;
    protected Node head;
    protected Node tail;

    /**
     * Creates an empty list.
     */
    public LinkedList() {
        count = 0;
        head = null;
        tail = null;
    }

    /**
     * Removes and returns the first element from the list.
     *
     * @return the first element of the list
     * @throws IllegalStateException if the list is empty
     */
    @Override
    public E removeFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("The LinkedList is empty.");
        }
        //return null;
        E temp = head.element;
        head = head.next;
        return temp;

        
        
    }

    /**
     * Removes and returns the last element from the list.
     *
     * @return the last element in the list
     * @throws IllegalStateException if the list is empty    
     */
    @Override
    public E removeLast() {
        if (isEmpty()) {
            throw new IllegalStateException("The LinkedList is empty.");
        }

       
        Node current = head;
        Node temp;
        while(current.next.next != null) 
          current = current.next;
        temp = tail;
        current.next = null;
        tail = current;
        return temp.element;

    }

    /**
     * Removes and returns the specified element from the list.
     *
     * @param  targetElement the element to be removed from the list
     * @return the removed element
     * @throws IllegalStateException if the list is empty
     * @throws NoSuchElementException if the target element is not found
     */
    @Override
    public E remove(E targetElement) {
        if (isEmpty()) {
            throw new IllegalStateException("The LinkedList is empty.");
        }

        
        if (contains(targetElement)) {
          Node current = head;
          Node temp =null;
          if (targetElement == head.element) {
            //System.out.println("first");
            removeFirst();
          }
          else if (targetElement == tail.element) {
            //System.out.println("last");
            removeLast();
          }
          else {
            //System.out.print("else");
            while ((current != null) && (current.element != targetElement)) {
              temp = current;
              current = current.next;
            }
            
            temp.next = current.next;
            
          } 
          
          
       
          return targetElement;
        }
        else
          System.out.println("list contains no such element");
          return targetElement;
          
    }

    /**
     * Returns the first element in the list without removing it.
     * 
     * @return the first element in the list
     * @throws IllegalStateException if the list is empty
     */
    @Override
    public E first() {
        if (isEmpty()) {
            throw new IllegalStateException("The LinkedList is empty.");
        }

        return head.element;
    }

    /**
     * Returns the last element in the list without removing it. 
     *
     * @return the last element in the list  
     * @throws IllegalStateException if the list is empty
     */
    @Override
    public E last() {
        if (isEmpty()) {
            throw new IllegalStateException("The LinkedList is empty.");
        }

        return tail.element;
    }

    /**
     * Returns true if the specified element is found in the list.
     *
     * @param  targetElement the element that is sought in the list
     * @return true if the element is found in the list
     * @throws IllegalStateException if the list is empty
     */
    @Override
    public boolean contains(E targetElement) {
        if (isEmpty()) {
            throw new IllegalStateException("The LinkedList is empty.");
        }

       
        Node current = head;
        while (current != null) {
          if (current.element.equals(targetElement))
            return true;
          current = current.next;
        }
        return false;
          

        
    }

    /**
     * Returns true if the list contains no elements.
     *
     * @return true if the list contains no elements
     */
    @Override
    public boolean isEmpty() {
        return (count == 0);
    }

    /**
     * Returns the number of elements in the list.
     *
     * @return the number of elements in the list
     */
    @Override
    public int size() {
        return count;
    }

    /**
     * Returns a string representation of the list.
     *
     * @return a string representation of the list    
     */
    @Override
    public String toString() {
        StringJoiner result = new StringJoiner(", ", "[", "]");

        Node current = head;
        while (current != null) {
            result.add(current.element.toString());
            current = current.next;
        }

        return result.toString();
    }
 }