/**
 * BinarySearchTree defines the interface to a binary search tree.
 * 
 * @author Java Foundations
 * @author Tim Harrison
 * @version 4.1
 */
/* Nov 2020 Tim Harrison
 * Changed interface name (removed ADT at end)
 * Changed coding style
 * Changed to use Comparable elements
 */
public interface BinarySearchTree<E extends Comparable<E>> extends BinaryTree<E> {
    /** 
     * Adds the specified element to the proper location in the tree. 
     *
     * @param element the element to be added to the tree
     */
    public void add(E element);

    /** 
     * Removes and returns the specified element from the tree. 
     *
     * @param targetElement the element to be removed from the tree
     * @return the element to be removed from the tree
     */ 
    public E remove(E targetElement);

    /** 
     * Removes and returns the smallest element from the tree. 
     *
     * @return the smallest element from the tree.
     */
    public E removeMin();

    /** 
     * Removes and returns the largest element from the tree. 
     *
     * @return the largest element from the tree
     */ 
    public E removeMax();

    /** 
     * Returns the smallest element in the tree without removing it. 
     * 
     * @return the smallest element in the tree
     */ 
    public E findMin();

    /** 
     * Returns the largest element in the tree without removing it. 
     * 
     * @return the largest element in the tree
     */
    public E findMax();
}


