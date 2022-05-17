public interface Queue<E> {
    /**
      * The element enters the queue at the rear.
      */
    public void enter(E element);

    /**
      * The front element leaves the queue and is returned.
      * @throws java.util.NoSuchElementException if queue is empty.
      */
    public E leave();

    /**
      * Returns True if the queue is empty.
      */
    public boolean isEmpty();

    /**
      * Returns the front element without removing it.
      * @throws java.util.NoSuchElementException if queue is empty.
      */
    public E front();
}

