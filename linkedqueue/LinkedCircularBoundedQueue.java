package linkedqueue;

import linkedlist.CircledLinkedList;

/*
    Information about time complexity is written in interface file.

    @see ICircularBoundedQueue
*/

/**
 * Implements ICircularBounded Queue using single LinkedList.
 * <p>
 * Contains also auxiliary function toString() to represent elements of a Queue as a String 
 * 
 * @author  Evgeny Gerasimov
 * @version 1.0; 12.02.2022
 * @see     ICircularBoundedQueue
 * @see     CircledLinkedList
 * @param   <T> the type of elements held in this Queue
 */

public class LinkedCircularBoundedQueue<T> implements ICircularBoundedQueue<T> {
    private int   capacity;

    CircledLinkedList<T> elements;

    /**
     * Creates a new Queue with given capacity.
     * 
     * @param capacity a possible number of elements in Queue
     */
    public LinkedCircularBoundedQueue(int capacity) {
        if (capacity <= 0)
            throw new IllegalStateException("Incorrect capacity");

        elements = new CircledLinkedList<>(capacity);

        this.capacity = capacity;
    }

    /**
     * Inserts an element to the rear of the Queue.
     * 
     * If the Queue is full, then the first element deletes
     */
    @Override
    public void offer(T value) {
        if (isFull())
            poll();
        
        elements.add(value);
    }

    /**
     * Removes first element from the Queue and returns its value.
     * 
     * @throws IllegalStateException if Queue is empty 
     * @return value of the first element in Queue
     */
    @Override
    public T poll() throws IllegalStateException {
        return elements.poll();
    }

    /**
     * Returns null if Queue is empty and value of the first element in Queue in other case.
     * 
     * @return null if Queue is empty and value of the first element in Queue in other case
     */
    @Override
    public T peek() {
        return elements.peek();
    }

    /**
     * Removes all elements from the Queue.
     */
    @Override
    public void flush() {
        elements.flush();
    }

    /**
     * Returns true if the Queue contains no elements.
     * 
     * @return true if the Queue contains no elements
     */
    @Override
    public boolean isEmpty() {
        return elements.isEmpty();
    }

    /**
     * Returns true if there is no free space in Queue.
     * 
     * @return true if there is no free space in Queue
     */
    @Override
    public boolean isFull() {
        return elements.size() == capacity;
    }

    /**
     * Returns number of active elements in Queue.
     * 
     * @return number of active elements in Queue
     */
    @Override
    public int size() {
        return elements.size();
    }

    /**
     * Returns how many elements can be pushed in the Queue.
     * 
     * @return how many elements can be pushed in the Queue
     */
    @Override
    public int capacity() {
        return capacity;
    }
    
    /**
     * Returns string with all values.
     * 
     * @return string with all values
     */
    @Override
    public String toString() {
        return elements.toString();
    }

    /**
     * Moves elements from current queue to another one.
     * 
     * @param to                        queue in which elements are moved
     * @param numberOfElements          number of elements to delete
     * @throws IllegalArgumentException if number of elements is incorrect
     */
    public void moveItemsToQueue(LinkedCircularBoundedQueue<T> to, int numberOfElements) throws IllegalArgumentException{
        if (numberOfElements > size())
            throw new IllegalArgumentException("Incorrect number of elements");

        for (int i = 0; i < numberOfElements; i++)
            to.offer(elements.poll());
    }
}
