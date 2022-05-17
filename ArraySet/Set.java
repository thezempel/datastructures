

import java.util.Iterator;

/**  
 * Set defines the interface to a set collection.
 * 
 * Solution to Programming Project 22.1
 *
 * @author Java Foundations
 */
public interface Set<E>
{
	/** 
	 * Adds one element to this set, ignoring duplicates. 
	 *
	 * @param element  the element to be added to this set
	 * @return true if the element was successfully added
	 */
	public boolean add(E element);

	/** 
	 * Removes and returns a random element from this set. 
	 * 
	 * @return  a random element from this set
	 */
	public E removeRandom();

	/** 
	 * Removes and returns the specified element from this set. 
	 *
	 * @param element  the element to be removed from this list
	 * @return         the element just removed from this list
	 */
	public E remove(E element);

	/**  
	 * Returns the union of this set and the parameter 
	 * 
	 * @param set  the set to be unioned with this set
	 * @return     a set that is the union of this set and the parameter
	 */
	public Set<E> union(Set<E> set);

	/**  
	 * Returns true if this set contains the parameter 
	 *
	 * @param target  the element being sought in this set
	 * @return        true if this set contains the parameter
	 */
	public boolean contains(E target);

	/**  
	 * Returns true if this set and the parameter contain exactly
	 * the same elements 
	 *
	 * @param set  the set to be compared with this set
	 * @return     true if this set and the parameter contain exactly
	 *             the same elements
	 */
	public boolean equals(Set<E> set);

	/**  
	 * Returns true if this set contains no elements 
	 *
	 * @return true if this set contains no elements
	 */
	public boolean isEmpty();

	/**  
	 * Returns the number of elements in this set 
	 *
	 * @return the integer number of elements in this set
	 */
	public int size();

	/**  
	 * Returns an iterator for the elements in this set 
	 *
	 * @return an iterator for the elements in this set
	 */
	public Iterator<E> iterator();

	/**  
	 * Returns a string representation of this set 
	 * 
	 * @return a string representation of this set
	 */
	public String toString();
}
