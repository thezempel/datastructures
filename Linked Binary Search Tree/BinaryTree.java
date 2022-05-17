import java.util.Iterator;

/**
 * BinaryTree defines the interface to a binary tree data structure.
 *
 * @author Java Foundations
 * @author Tim Harrison
 * @version 4.1
 */
/* Nov 2020 Tim Harrison
 * Changed interface name (BinaryTreeADT -> BinaryTree)
 */
public interface BinaryTree <E> {
    /** 
     * Returns true if the binary tree is empty, false otherwise.
     *
     * @return true if the binary tree is empty, false otherwise
     */
    public boolean isEmpty();

    /** 
     * Returns the number of elements in the binary tree.
     *
     * @return the number of elements in the binary tree
     */
    public int size();

    /** 
     * Returns the height of the tree.
     *
     * @return the height of the tree
     */
    public int height();

    /** 
     * Returns true if the binary tree contains an element that matches
     * the specified element and false otherwise. 
     *
     * @param targetElement the element being sought in the tree
     * @return true if the tree contains the target element
     */
    public boolean contains(E targetElement);

    /** 
     * Returns a reference to the specified element if it is found in 
     * the binary tree. Throws an exception if the specified element
     * is not found.
     *
     * @param targetElement the element being sought in the tree
     * @return a reference to the specified element
     */
    public E find(E targetElement);

    /**  
     * Returns the string representation of the binary tree.
     *
     * @return a string representation of the binary tree
     */
    public String toString();

    /**  
     * Returns an iterator over the elements of the tree.
     *
     * @return an iterator over the elements of the binary tree
     */
    public Iterator <E> iterator();

    /**  
     * Returns an iterator that represents an inorder traversal on the binary tree.  
     *
     * @return an iterator over the elements of the binary tree
     */
    public Iterator <E> iteratorInOrder();

    /**  
     * Returns an iterator that represents a preorder traversal on the binary tree. 
     *
     * @return an iterator over the elements of the binary tree
     */
    public Iterator <E> iteratorPreOrder();

    /**  
     * Returns an iterator that represents a postorder traversal on the binary tree. 
     *
     * @return an iterator over the elements of the binary tree
     */
    public Iterator <E> iteratorPostOrder();

    /**  
     * Returns an iterator that represents a levelorder traversal on the binary tree. 
     *
     * @return an iterator over the elements of the binary tree
     */
    public Iterator<E> iteratorLevelOrder();
}