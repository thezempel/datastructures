import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;

/**    
 * ArraySet represents an array implementation of a set.
 * 
 * Programming Project 22.1
 *
 * @author Java Foundations
 * @author Jonathon Zempel
 *
 * @version 2021-08-23
 */
/*
 * Tim Harrison Modifications (May 2020):
 *   - Changed <T> to <E> and all dependent changes.
 *   - Changed Java code style
 *   - Changed implements SetADT to implements Set.
 */   
public class ArraySet<E> implements Set<E>, Iterable<E> {
    private static Random rand = new Random();
    private final int DEFAULT_CAPACITY = 100;
    private final int NOT_FOUND = -1;
    private int count;    // the current number of elements in the set
    private E[] contents; 
    private int modCount;

    /**
     * Creates an empty set using the default capacity.
     */
    public ArraySet() {
        count = 0;
        modCount = 0;
        contents = (E[])(new Object[DEFAULT_CAPACITY]);
    }

    /**
     * Creates an empty set using the specified capacity.
     *
     * @param initialCapacity    the initial capacity for the array set
     */
    public ArraySet(int initialCapacity) {
        count = 0;
        contents = (E[])(new Object[initialCapacity]);
    }

    /**
     * Adds the specified element to the set if it is not already
     * present. Expands the capacity of the set array if necessary.
     *
     * @param element the element to be added to the set array
     */
    public boolean add(E element) {
        boolean result = false;

        if (!(contains(element))) {
            if (size() == contents.length) {
                expandCapacity();
            }

            contents[count] = element;
            count += 1;
            result = true;
        }
        modCount += 1;
        return result;
    }

    /**
     * Adds the contents of the parameter to this set.
     *
     * @param set the collection to be added to this set
     */
    public void addAll(Set<E> set) {
        Iterator<E> scan = set.iterator();

        while (scan.hasNext()) {
            add (scan.next());
        }

        modCount += 1;
    }

    /**
     * Removes a random element from the set and returns it. Throws
     * an NoSuchElementException if the set is empty.
     *
     * @return a random element from the set
     * @throws NoSuchElementException  if an empty set exception occurs
     */
    public E removeRandom() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException("ArraySet");
        }

        int choice = rand.nextInt(count);

        E result = contents[choice];

        contents[choice] = contents[count-1];    // fill the gap
        contents[count-1] = null;
        count--;
        modCount += 1;

        return result;
    }

    /**
     * Removes the specified element from the set and returns it.
     * Throws an NoSuchElementException if the set is empty and a
     * NoSuchElementException if the target is not in the set.
     *
     * @param target  the element being sought in the set
     * @return the element specified by the target
     * @throws NoSuchElementException if an empty set exception occurs
     * @throws NoSuchElementException if a no such element exception occurs
     */
    public E remove(E target) throws NoSuchElementException,    NoSuchElementException {
        int search = NOT_FOUND;

        if (isEmpty()) {
            throw new NoSuchElementException("ArraySet");
        }

        for (int index=0; index < count && search == NOT_FOUND; index += 1) {
            if (contents[index].equals(target)) {
                search = index;
            }
        }

        if (search == NOT_FOUND) {
            throw new NoSuchElementException();
        }

        E result = contents[search];

        contents[search] = contents[count-1];
        contents[count-1] = null;
        count--;
        modCount += 1;

        return result;
    }

    /**
     * Returns a new set that is the union of this set and the
     * parameter.
     *
     * @param set    the set that is to be unioned with this set
     * @return       a new set that that is the union of this set and 
     *               the parameter
     */
    public Set<E> union(Set<E> set) {
        // Implemented
	    ArraySet<E> union = new ArraySet<E>();

	    for (int index = 0; index < count; index++) 
		    union.add(contents[index]);	
	    Iterator<E> scan = set.iterator();
	    while (scan.hasNext()) {
		    union.add(scan.next());
      }
      return union; 
    }

    /**
     * Returns a new set that is the difference of this set and the
     * parameter.
     *
     * @param set    the set that is to be differenced with this set
     * @return       a new set that that is the difference of this set and 
     *               the parameter
     */
    public Set<E> difference(Set<E> set) {
        ArraySet<E> diff = new ArraySet<E>();

        for (int index = 0; index < count; index += 1) {
          if (!(set.contains(contents[index]))) {
              diff.add (contents[index]);
          }
        }

        return diff;
    }

    /**
     * Returns a new set that is the intersection of this set and the
     * parameter.
     *
     * @param set    the set that is to be intersected with this set
     * @return       a new set that that is the intersection of this set and 
     *               the parameter
     */
    public Set<E> intersection(Set<E> set) {
        // Implemented
	    ArraySet<E> same = new ArraySet<E>();
	
	    for (int index = 0; index < count; index++) {
		    if (set.contains(contents[index]))
			    same.add(contents[index]);
      }
      return same; 
    }
  
    /**
     * Returns true if this set contains the specified target
     * element.
     *
     * @param target    the element being sought within this set
     * @return          true if the set contains the target element
     */
    public boolean contains (E target) {
        int search = NOT_FOUND;

        for (int index=0; index < count && search == NOT_FOUND; index += 1) {
            if (contents[index].equals(target)) {
                search = index;
            }
        }

        return (search != NOT_FOUND);
    }

    /**
     * Returns true if this set contains exactly the same elements
     * as the parameter.
     *
     * @param set    the set to be compared with this set
     * @return       true if the parameter set and this set contain
     *               exactly the same elements
     */
    public boolean equals(Set<E> set) {
        boolean result = false;
        ArraySet<E> temp1 = new ArraySet<E>();
        ArraySet<E> temp2 = new ArraySet<E>();
        E element;

        if (size() == set.size()) {
            temp1.addAll(this);
            temp2.addAll(set);

            Iterator<E> scan = set.iterator();

            while (scan.hasNext()) {
                element = scan.next();     
                if (temp1.contains(element)) {
                    temp1.remove(element);
                    temp2.remove(element);
                }
            }

            result = (temp1.isEmpty() && temp2.isEmpty());
        }

        return result;
    }

    /**
     * Returns true if this set is empty and false otherwise.
     *
     * @return    true if this set is empty
     */
    public boolean isEmpty() {
        return (count == 0);
    }

    /**
     * Returns the number of elements currently in this set.
     *
     * @return    the integer number of elements in this set
     */
    public int size() {
        return count;
    }

    /**
     * Returns an iterator for the elements currently in this set.
     *
     * @return    an iterator for the elements in this set
     */
    public Iterator<E> iterator() {
        return new ArraySetIterator();
    }

    /**
     * Returns a string representation of this set.
     *
     * @return    a string representation of this set
     */
    public String toString() {
        String result = "";

        for (int index=0; index < count; index += 1) {
            result = result + contents[index].toString() + "\n";
        }

        return result;
    }

    /**
     * Creates a new array to store the contents of the set with
     * twice the capacity of the old one.
     */
    private void expandCapacity() {
        E[] larger = (E[])(new Object[contents.length*2]);

        for (int index=0; index < contents.length; index += 1) {
            larger[index] = contents[index];
        }

        contents = larger;
    }

    /**
     * ArraySetIterator iterator over the elements of an ArraySet.
     */ 
    private class ArraySetIterator implements Iterator<E> {
        int iteratorModCount;
        int current;

        /**
         * Sets up this iterator using the current modCount.
         * 
         */
        public ArraySetIterator() {
            iteratorModCount = modCount;
            current = 0;
        }

        /**
         * Returns true if this iterator has at least one more element
         * to deliver in the iteration.
         *
         * @return  true if this iterator has at least one more element to deliver
         *          in the iteration
         * @throws  ConcurrentModificationException if the collection has changed
         *          while the iterator is in use
         */
        public boolean hasNext() throws ConcurrentModificationException {
            if (iteratorModCount != modCount) {
                throw new ConcurrentModificationException();
            }

            return (current < count);
        }

        /**
         * Returns the next element in the iteration. If there are no
         * more elements in this iteration, a NoSuchElementException is
         * thrown.
         *
         * @return  the next element in the iteration
         * @throws  NoSuchElementException if an element not found exception occurs
         * @throws  ConcurrentModificationException if the collection has changed
         */
        public E next() throws ConcurrentModificationException {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            current += 1;

            return contents[current - 1];
        }

        /**
         * The remove operation is not supported in this collection.
         * 
         * @throws UnsupportedOperationException if the remove method is called
         */
        public void remove() throws UnsupportedOperationException {
            throw new UnsupportedOperationException();
        }
    }   

}

