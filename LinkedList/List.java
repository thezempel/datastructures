/**
 * List defines the interface to a general list collection. Specific
 * types of lists extend the interface to complete the set of
 * necessary operations.
 *
 * @author Java Foundations / Tim Harrison
 * @version 2020-11-05
 */
public interface List<E> {
    /**
     * Removes and returns the first element from the list.
     *
     * @return the first element of the list
     */
    public E removeFirst();

    /**
     * Removes and returns the last element from the list.
     *
     * @return the last element in the list
     */
    public E removeLast();

    /**
     * Removes and returns the specified element from the list.
     *
     * @param  targetElement the element to be removed from the list
     * @return the removed element
     */
    public E remove(E element);

    /**
     * Returns the first element in the list without removing it.
     * 
     * @return the first element in the list
     */
    public E first();

    /**
     * Returns the last element in the list without removing it. 
     *
     * @return the last element in the list  
     */
    public E last();

    /**
     * Returns true if the specified element is found in the list.
     *
     * @param  targetElement the element that is sought in the list
     * @return true if the element is found in the list
     */
    public boolean contains(E targetElement);

    /**
     * Returns true if the list contains no elements.
     *
     * @return true if the list contains no elements
     */
    public boolean isEmpty();

    /**  
     * Returns the number of elements in the list. 
     *
     * @return number of elements in the list
     */
    public int size();

    /**  
     * Returns a string representation of the list. 
     *
     * @return a string representation of the list
     */
    public String toString();
}