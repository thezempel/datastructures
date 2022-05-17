import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * LinkedBinaryTree implements the BinaryTree interface.
 * 
 * @author Java Foundations
 * @author Tim Harrison
 * @version 4.1
 */
/* Nov 2020 Tim Harrison
 * Changed code style
 * Inserted BinaryTreeNode as an inner class
 * Changed exceptions being used to standard Java exceptions instead of custom exceptions
 * Changed to use java.util.ArrayList instead of custom UnorderedArrayList
 */              
public abstract class LinkedBinaryTree<E> implements BinaryTree<E>, Iterable<E> {
    protected class LinkedBinaryTreeNode {
        public E element;
        public LinkedBinaryTreeNode left;
        public LinkedBinaryTreeNode right;
    
        public LinkedBinaryTreeNode(E element) {
            this(element, null, null);
        }
    
        public LinkedBinaryTreeNode(E element,
                LinkedBinaryTreeNode left, LinkedBinaryTreeNode right) {
            this.element = element;
            this.left = left;
            this.right = left;
        }
    
        public int numChildren() {
            return 
                ((left == null) ? 0 : 1 + left.numChildren()) +
                ((right == null) ? 0 : 1 + right.numChildren());
        }
    
        public boolean isLeaf() {
            return (left == null && right == null);
        }
    } // class LinkedBinaryTreeNode

    protected LinkedBinaryTreeNode root; 
    protected int modCount;

    /**
     * Creates an empty binary tree.
     */
    public LinkedBinaryTree() {
        root = null;
    }

    /**
     * Creates a binary tree with the specified element as its root.
     *
     * @param element the element that will become the root of the binary tree
     */
    public LinkedBinaryTree(E element) {
        root = new LinkedBinaryTreeNode(element);
    }

    /**
     * Creates a binary tree with the specified element as its root and the 
     * given trees as its left child and right child
     *
     * @param element the element that will become the root of the binary tree
     * @param left the left subtree of the tree
     * @param right the right subtree of the tree
     */
    public LinkedBinaryTree(E element, LinkedBinaryTree left, LinkedBinaryTree right) {
        root = new LinkedBinaryTreeNode(element);
        root.left = left.root;
        root.right = right.root;
    }

    /**
     * Returns true if the binary tree is empty and false otherwise.
     *
     * @return true if the binary tree is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return (root == null);
    }

    /**
     * Returns the integer size of the tree.
     *
     * @return the integer size of the tree
     */
    @Override
    public int size() {
        return 1 + root.numChildren();
    }

    /**
     * Returns the height of the tree.
     *
     * @return the height of the tree
     */
    @Override
    public int height() {
        return height(root) - 1;
    }

    /**
     * Returns the height of the specified node.
     *
     * @param node the node from which to calculate the height
     * @return the height of the tree
     */
    private int height(LinkedBinaryTreeNode node) {
        return (node == null) ? 0 : 1 + Math.max(height(node.left), height(node.right));
    }

    /**
     * Returns true if the tree contains an element that matches the
     * specified target element and false otherwise.
     *
     * @param targetElement the element being sought in the tree
     * @return true if the element in is the tree, false otherwise
     */
    @Override
    public boolean contains(E targetElement) {
        E temp;
        boolean found = false;
        
        try {
            temp = find(targetElement);
            found = true;
        } catch (NoSuchElementException e) {
            found = false;
        }
        
        return found;
    }

    /**
     * Returns a reference to the specified target element if it is
     * found in the binary tree.  Throws NoSuchElementException if
     * the specified target element is not found in the binary tree.
     *
     * @param targetElement the element being sought in the tree
     * @return a reference to the specified target
     * @throws NoSuchElementException if the element is not in the tree
     */
    @Override
    public E find(E targetElement) {
        var result = findNode(targetElement, root);

        if (result == null) {
            throw new NoSuchElementException("LinkedBinaryTree");
        }

        return (result.element);
    }

    /**
     * Returns a reference to the specified target element if it is
     * found in the binary tree.
     *
     * @param targetElement the element being sought in the tree
     * @param next the element to begin searching from
     */
    private LinkedBinaryTreeNode findNode(E targetElement, LinkedBinaryTreeNode next) {
        if (next == null) {
            return null;
        }

        if (next.element.equals(targetElement)) {
            return next;
        }

        var temp = findNode(targetElement, next.left);

        if (temp == null) { // targetElement not found, yet
            temp = findNode(targetElement, next.right);
        }

        return temp;
    }

    /**
     * Returns a string representation of the binary tree showing
     * the nodes in an inorder fashion.
     *
     * @return a string representation of the binary tree
     */
    @Override
    public String toString() {
        var tempList = new ArrayList<E>();
        inOrder(root, tempList);
        
        return tempList.toString();
    }

    /**
     * Returns an iterator over the elements in the tree using the 
     * iteratorInOrder method
     *
     * @return an in order iterator over the binary tree
     */
    @Override
    public Iterator<E> iterator() {
        return iteratorInOrder();
    }

    /**
     * Performs an inorder traversal on the binary tree by calling an
     * overloaded, recursive inorder method that starts with
     * the root.
     *
     * @return an in order iterator over the binary tree
     */
    @Override
    public Iterator<E> iteratorInOrder() {
        var tempList = new ArrayList<E>();
        inOrder(root, tempList);

        return new TreeIterator(tempList.iterator());
    }

    /**
     * Performs a recursive inorder traversal.
     *
     * @param node the node to be used as the root for the traversal
     * @param tempList the temporary list for use in the traversal
     */
    protected void inOrder(LinkedBinaryTreeNode node, ArrayList<E> tempList) {
        if (node != null) {
            inOrder(node.left, tempList);
            tempList.add(node.element);
            inOrder(node.right, tempList);
        }
    }

    /**
     * Performs an preorder traversal on the binary tree by calling 
     * an overloaded, recursive preorder method that starts with
     * the root.
     *
     * @return a pre order iterator over the tree
     */
    @Override
    public Iterator<E> iteratorPreOrder() {
        var tempList = new ArrayList<E>();
        preOrder(root, tempList);
        
        return new TreeIterator(tempList.iterator());
    }

    /**
     * Performs a recursive preorder traversal.
     *
     * @param node the node to be used as the root for the traversal
     * @param tempList the temporary list for use in the traversal
     */
    protected void preOrder(LinkedBinaryTreeNode node, ArrayList<E> tempList) {
        if (node != null) {
            tempList.add(node.element);
            preOrder(node.left, tempList);
            preOrder(node.right, tempList);
        }
    }

    /**
     * Performs an postorder traversal on the binary tree by calling
     * an overloaded, recursive postorder method that starts
     * with the root.
     *
     * @return a post order iterator over the tree
     */
    @Override
    public Iterator<E> iteratorPostOrder() {
        var tempList = new ArrayList<E>();
        postOrder(root, tempList);
        
        return new TreeIterator(tempList.iterator());
    }

    /**
     * Performs a recursive postorder traversal.
     *
     * @param node the node to be used as the root for the traversal
     * @param tempList the temporary list for use in the traversal
     */
    protected void postOrder(LinkedBinaryTreeNode node, ArrayList<E> tempList) {
        if (node != null) {
            postOrder(node.left, tempList);
            postOrder(node.right, tempList);
            tempList.add(node.element);
        }
    }

    /**
     * Performs a levelorder traversal on the binary tree, using a
     * templist.
     *
     * @return a levelorder iterator over the binary tree
     */
    @Override
    public Iterator<E> iteratorLevelOrder() {
        var nodeQueue = new ArrayList<LinkedBinaryTreeNode>();
        var elements = new ArrayList<E>();
        LinkedBinaryTreeNode nextNode;

        nodeQueue.add(root);

        while (!nodeQueue.isEmpty()) {
            nextNode = nodeQueue.remove(0);

            if (nextNode != null) {
                elements.add(nextNode.element);
                if (nextNode.left != null) {
                    nodeQueue.add(nextNode.left);
                }
                if (nextNode.right != null) {
                    nodeQueue.add(nextNode.right);
                }
            } else {
                elements.add(null);
            }
        }

        return new TreeIterator(elements.iterator());
    }

    /**
     * Inner class to represent an iterator over the elements of the tree
     */
    private class TreeIterator implements Iterator<E> {
        private int expectedModCount;
        private Iterator<E> iterator;

        /**
         * Sets up the iterator using the specified iterator.
         *
         * @param iterator the list iterator created by a tree traversal
         */
        public TreeIterator(Iterator<E> iterator) {
            this.iterator = iterator;
            expectedModCount = modCount;
        }

        /**
         * Returns true if the iterator has at least one more element
         * to deliver in the iteration.
         *
         * @return  true if the iterator has at least one more element to deliver
         *          in the iteration
         * @throws  ConcurrentModificationException if the collection has changed
         *          while the iterator is in use
         */
        @Override
        public boolean hasNext() {
            if (! (modCount == expectedModCount)) {
                throw new ConcurrentModificationException();
            }

            return (iterator.hasNext());
        }

        /**
         * Returns the next element in the iteration. If there are no
         * more elements in the iteration, a NoSuchElementException is
         * thrown.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iterator is empty
         */
        @Override
        public E next() {
            if (! hasNext()) {
                throw new NoSuchElementException();
            }
            
            return (iterator.next());
        }

        /**
         * The remove operation is not supported.
         * 
         * @throws UnsupportedOperationException if the remove operation is called
         */
        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}

