/**
 * A container holding a sequence of elements that can be accessed, inserted, or removed at only one end, called the top.
 *
 * @author Tim Harrison
 * @version 2020-04-12
 */
public interface Stack<E> {
    /**
     * Push an element onto the stack.
     * 
     * @param  element, a value to be pushed on the stack
     */
    public void push(E element);
    
    /**
     * Pop the top element off the stack.
     */
    public E pop();
    
    /**
     * Return the top element on the stack.
     */
    public E top();
    
    /**
     * Return True if the stack contains no elements.
     * 
     * @return true if there are no elements in the stack
     */
    public boolean isEmpty();
}
