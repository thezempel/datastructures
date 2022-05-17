/**
 * LinkedOrderedList represents a singly linked implementation of an 
 * ordered list.
 *
 * @author Jonathon Zempel
 * @version 2021-07-18
 */
public class LinkedOrderedList<E> extends LinkedList<E> implements OrderedList<E> {
    /**
     * Creates an empty list.
     */
    public LinkedOrderedList() {
        super();
    }

    /**
     * Adds the specified element to this list at the location determined by
     * the element's natural ordering.
     *
     * @param element the element to be added to this list
     * @throws IllegalStateException if the element is not of a Comparable type
     */
    @Override
    public void add(E element) {
        if (!(element instanceof Comparable)) {
            throw new IllegalStateException("LinkedOrderedList requires Comparable elements.");
		    }
      
      Node newNode = new Node(element);
      
	    var comparableElement = (Comparable<E>) element;
      //adds to empty list
      if (isEmpty()) {
        head = new Node(element, head);
        tail = head;
        count++;

             
      }
      //adds to front if value less than front
      
      else if (comparableElement.compareTo(head.element)<=0) {

        newNode.next = head;
        head = newNode;
        count++;

    
        
      }
      //adds to tail if value greater than tail
      else if (comparableElement.compareTo(tail.element)>=0) {
        tail.next = newNode;
        tail = newNode;
        count++;


      }
      //adds everywhere in between head and tail
      else {
        Node current = head;
        
        
          while ((comparableElement.compareTo(current.next.element) >= 0)) {
            current = current.next;
          }
          newNode.next = current.next;
          current.next = newNode;
          count++;
          
        }
       
      }

    }
  

