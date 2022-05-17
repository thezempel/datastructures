/**
 * A container holding a sequence of elements that can be accessed, inserted, or removed at only one end, called the top.
 *
 * @author Tim Harrison
 * @version 2020-10-20
 */
public interface Stack<E> {
    /**
     * Push an element onto the stack.
     * 
     * @param  element, a value to be pushed on the stack.
     */
    public void push(E element);
    
    /**
     * Remove the last element pushed on the stack and return it.
     * 
     * @throws EmptyStackException if stack is empty when called
     * @return the last element pushed onto the stack.
     */
    public E pop();
    
    /**
     * Return the last element pushed on the stack.
     * 
     * @throws EmptyStackException if stack is empty when called
     * @return the top element on the stack.
     */
    public E top();
    
    /**
     * Return True if the stack contains no elements.
     * 
     * @return True if the stack contains no elements.
     */
    public boolean isEmpty();
     
    /**
     * Return the number of elements on the stack.
     * 
     * @return the number of elements on the stack.
     */
    public int size();
}
