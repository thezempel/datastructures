/**
 * An array implementation of the Stack interface.
 *
 * @author <Jonathon Zempel>
 * @version <2021-06-30>
 */

import java.util.EmptyStackException;

public class ArrayStack<E> implements Stack<E> {
    private final static int DEFAULT_CAPACITY = 100;
    private final static int EMPTY_INDEX = -1;
    
    private E[] stack;
    private int top = EMPTY_INDEX; // Index of the top element on the stack

    public ArrayStack() {
        this(DEFAULT_CAPACITY);
    }
    
    public ArrayStack(int initialCapacity) {
        initialCapacity = initialCapacity < 0 ? 0 : initialCapacity;
        stack = (E[]) new Object[initialCapacity];
    }

    @Override
    public void push(E element) {
        // Adds element to top of stack
        // expands capacity if necessary
        if (isFull())          
          expandCapacity();
        
        top++;
        stack[top] = element;
        
    }
    
    @Override
    public E pop() {
        // removes element from top of stack, returning reference to it
        E popped = stack[top];
        top--;
        return popped;
    }
    
    @Override
    public E top() {
        // returns reference of element on top of stack
        return stack[top];
    }
    
    @Override
    public boolean isEmpty() {
        // returns true if empty, false otherwise
      return (top == EMPTY_INDEX);
    }
    
    private boolean isFull() {
        // returns true if full, false otherwise  
        return ((top + 1) == capacity());
    }
    
    private void expandCapacity() {
        E[] temp = (E[]) new Object[stack.length * 2 + 1];
        System.arraycopy(stack, 0, temp, 0, stack.length);
        stack = temp;
    }
    
    public int capacity() {
        return stack.length;
    }
    
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("[");
        if (! isEmpty()) {
            for (int i = top; 0 < i; i -= 1) {
                result.append(stack[i] + ", ");
            }
            result.append(stack[0]);
        }
        result.append("]");
        return result.toString();
    }
}