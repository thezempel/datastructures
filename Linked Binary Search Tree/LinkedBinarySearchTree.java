import java.util.NoSuchElementException;

/**
 * LinkedBinarySearchTree implements the BinarySearchTree interface 
 * with links.
 * 
 * @author Java Foundations
 * @author Tim Harrison
 * @author Jonathon Zempel
 * @version 2021-08-11
 */
/* Nov 2020 Tim Harrison
 * Changed to use Comparable elements
 * Changed code style
 * Changed exceptions being used to standard Java exceptions instead of custom exceptions
 */
public class LinkedBinarySearchTree<E extends Comparable<E>>
        extends LinkedBinaryTree<E>
        implements BinarySearchTree<E> {
    /**
     * Creates an empty binary search tree.
     */
    public LinkedBinarySearchTree() {
        super();
    }

    /**
     * Creates a binary search with the specified element as its root.
     *
     * @param element the element that will be the root of the new binary
     *        search tree
     */
    public LinkedBinarySearchTree(E element) {
        super(element);
    }

    /**
     * Adds the specified object to the binary search tree in the
     * appropriate position according to its natural order. Equal elements
     * may not be added.
     *
     * @param element the element to be added to the binary search tree
     */
    @Override
    public void add(E element) {
        if (isEmpty()) { // Add as root of new tree
            root = new LinkedBinaryTreeNode(element);
            modCount += 1;
        } else if (element.compareTo(root.element) < 0) { // Add to left subtree
            if (root.left == null) {
                root.left = new LinkedBinaryTreeNode(element);
            } else {
                add(element, root.left);
            }
            modCount += 1;
        } else if (0 < element.compareTo(root.element)){ // Add to right subtree
            if (root.right == null) {
                root.right = new LinkedBinaryTreeNode(element);
            } else {
                add(element, root.right);
            }
            modCount += 1;
        } else { // Element found in tree. Do not add to tree.
        }
    }

    /**
     * Adds the specified object to the binary search tree in the
     * appropriate position according to its natural order.  Note that
     * equal elements are added to the right.
     *
     * @param element the element to be added to the binary search tree
     */
    private void add(E element, LinkedBinaryTreeNode node) {
        if (element.compareTo(node.element) < 0) { // Add to left subtree
            if (node.left == null) {
                node.left = new LinkedBinaryTreeNode(element);
            } else {
                add(element, node.left);
            }
        } else if (0 < element.compareTo(node.element)) { // Add to right subtree
            if (node.right == null) {
                node.right = new LinkedBinaryTreeNode(element);
            } else {
                add(element, node.right);
            }
        } else { // Element found in tree. Do not add to tree.
        }
    }

    /**
     * Removes the first element that matches the specified target
     * element from the binary search tree and returns a reference to
     * it.  Throws NoSuchElementException if the specified target
     * element is not found in the binary search tree.
     *
     * @param targetElement the element being sought in the binary search tree
     * @throws NoSuchElementException if the target element is not found
     */
    @Override
    public E remove(E targetElement) {
        if (isEmpty()) {
            throw new NoSuchElementException("LinkedBinarySearchTree");
        }

        E result = null;

        LinkedBinaryTreeNode parent = null;
        if (targetElement.equals(root.element)) { // Target element found
            result =  root.element;
            LinkedBinaryTreeNode temp = replacement(root);
            if (temp == null) {
                root = null;
            } else {
                root.element = temp.element;
                root.right = temp.right;
                root.left = temp.left;
            }

            modCount -= 1;
        } else { // Target element not found    
            parent = root;
            if (targetElement.compareTo(root.element) < 0) {
                result = removeElement(targetElement, root.left, parent);
            } else {
                result = removeElement(targetElement, root.right, parent);
            }
        }

        return result;
    }

    /**
     * Removes the first element that matches the specified target
     * element from the binary search tree and returns a reference to
     * it.  Throws NoSuchElementException if the specified target
     * element is not found in the binary search tree.
     *
     * @param targetElement the element being sought in the binary search tree
     * @param node the node from which to search
     * @param parent the parent of the node from which to search
     * @throws NoSuchElementException if the target element is not found
     */
    private E removeElement(E targetElement,
            LinkedBinaryTreeNode node, LinkedBinaryTreeNode parent) {
        if (node == null) {
            throw new NoSuchElementException("LinkedBinarySearchTree");
        }
        
        E result = null;

        if (targetElement.equals(node.element)) { // Target element found.
            result =  node.element;
            LinkedBinaryTreeNode temp = replacement(node);
            
            if (parent.right == node) {
                parent.right = temp;
            } else {
                parent.left = temp;
            }

            modCount -= 1;
        } else { // Target element not found      
            parent = node;
            if (targetElement.compareTo(node.element) < 0) { // Look in left subtree
                result = removeElement(targetElement, node.left, parent);
            } else { // Look in right subtree
                result = removeElement(targetElement, node.right, parent);
            }
        }

        return result;
    }

    /**
     * Returns a reference to a node that will replace the one
     * specified for removal. In the case where the removed node has 
     * two children, the inorder successor is used as its replacement.
     *
     * @param node the node to be removed
     * @return a reference to the replacing node
     */
    private LinkedBinaryTreeNode replacement(LinkedBinaryTreeNode node) {
        LinkedBinaryTreeNode result = null;

        if ((node.left == null) && (node.right == null)) { // No children
            result = null;
        } else if ((node.left != null) && (node.right == null)) { // Left child only
            result = node.left;
        } else if ((node.left == null) && (node.right != null)) { // Right child only
            result = node.right;
        } else { // Two children
            // Find leftmost descendant of right subtree
            LinkedBinaryTreeNode parent = node;
            LinkedBinaryTreeNode cursor = node.right;
            while (cursor.left != null) {
                parent = cursor;
                cursor = cursor.left;
            }

            // Restructure the tree
            cursor.left = node.left;
            if (node.right != cursor) {
                parent.left = cursor.right;
                cursor.right = node.right;
            }

            result = cursor;
        }

        return result;
    }

    /**
     * Removes the node with the least value from the binary search
     * tree and returns a reference to its element. Throws
     * IllegalStateException if the tree is empty. 
     *
     * @return a reference to the node with the least value
     * @throws IllegalStateException if the tree is empty
     */
    @Override
    public E removeMin() {
        if (isEmpty()) {
            throw new IllegalStateException("LinkedBinarySearchTree");
        }

        E result = null;

        if (root.left == null) { // Minimum element is the root
            result = root.element;
            root = root.right;
        } else { // Minimum element is in the left subtree
            // Find leftmost descendant of left subtree
            LinkedBinaryTreeNode parent = root;
            LinkedBinaryTreeNode cursor = root.left;
            while (cursor.left != null) {
                parent = cursor;
                cursor = cursor.left;
            }
            
            result =  cursor.element;
            
            // Restructure the tree
            parent.left = cursor.right;
        }

        modCount -= 1;

        return result;
    }

    /**
     * Removes the node with the highest value from the binary
     * search tree and returns a reference to its element. Throws
     * IllegalStateException if the tree is empty. 
     *
     * @return a reference to the node with the highest value
     * @throws IllegalStateException if the tree is empty
     */
    @Override
    public E removeMax() {
        //implemented.
        if (isEmpty()) {
          throw new IllegalStateException("I cant do that Hal..");
        }
        E result = null;
        if (root.right == null) {
          result = root.element;
          root = root.left;
        }
        else {
            LinkedBinaryTreeNode parent = root;
            LinkedBinaryTreeNode current = root.right;
            while (current.right != null) {
              parent = current;
              current = current.right;
            }
            result = current.element;
            parent.right = current.left;
          }
          modCount -= 1;
          return result;
        
    }

    /**
     * Returns the element with the least value in the binary search
     * tree. It does not remove the node from the binary search tree. 
     * Throws IllegalStateException if the tree is empty.
     *
     * @return the element with the least value
     * @throws IllegalStateException if the tree is empty
     */
    @Override
    public E findMin() {
        // implemented.
        if (isEmpty()) {
          throw new IllegalStateException("whoops, nothing there");
        }
        E min = null;
        if (root.left == null) {
          min = root.element;
        }
        else {
          LinkedBinaryTreeNode current = root;
          while (current.left != null) {
            current = current.left;
          }
          min = current.element;
        
        }
        return min;
    }

    /**
     * Returns the element with the highest value in the binary
     * search tree. It does not remove the node from the binary
     * search tree. Throws IllegalStateException if the 
     * tree is empty.
     *
     * @return the element with the highest value
     * @throws IllegalStateException if the tree is empty
     */
    @Override
    public E findMax() {
        //implemented.
        if (isEmpty()) {
          throw new IllegalStateException("(angry beeping noises)");
        }
        E max = null;
        if (root.right == null) {
          max = root.element ;
        }
        else {
          LinkedBinaryTreeNode current = root;
          while (current.right != null) {
            current = current.right;
          }
          max = current.element;
        }
        return max;
    }
}

