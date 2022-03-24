package linkedqueue;

/*
    In comments information about time complexity in the worst case of each method is given.
*/

/**
 * ADS for a Queue
 * 
 * @param <T> the type of elements held in this Queue
 */
public interface ICircularBoundedQueue <T> {
    void    offer(T value); // works for O(1) inserts an element to the rear of the queue
                            //                overwrites the oldest elements when the queue is full

    T       poll();         // works for O(1) removes an element from the front of the queue
    T       peek();         // works for O(1) looks at the element at the front of the queue
                            //                (without removing it)

    void    flush();        // works for O(1) removes all elements from the queue
    boolean isEmpty();      // works for O(1) is the queue empty?
    boolean isFull();       // works for O(1) is the queue full?
    int     size();         // works for O(1) number of elements
    int     capacity();     // works for O(1) maximum capacity

}