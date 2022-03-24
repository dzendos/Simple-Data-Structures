package linkedlist;

/**
 * ADS for a LinkedList
 * 
 * @param <T> the type of elements held in this Queue
 */
public interface ILinkedList<T> {
    void    add(T value); // inserts an element to the rear of the queue

    T       poll();       // removes an element from the front of the queue
    T       peek();       // looks at the element at the front of the queue

    void    flush();      // removes all elements from the queue
    boolean isEmpty();    // is the queue empty?
    int     size();       // number of elements
}