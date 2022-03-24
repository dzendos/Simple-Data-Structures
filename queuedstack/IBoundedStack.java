package queuedstack;

/*
    In comments information about time complexity in the worst case of each method is given.
*/

/**
 * ADS for a Stack
 * 
 * @param <T> the type of elements held in this Queue
 */
public interface IBoundedStack<T> {
    void    push(T value); // works for O(1) pushes an element onto the stack
                           //                removes the oldest element when the stack is full

    T       pop();         // works for O(n) removes an element from the top of the stack
    T       top();         // works for O(n) looks at the element at the top of the stack (without removing it)
                           
    void    flush();       // works for O(1) removes all elements from the stack
    boolean isEmpty();     // works for O(1) is the stack empty?
    boolean isFull();      // works for O(1) is the stack full?
    int     size();        // works for O(1) number of elements
    int     capacity();    // works for O(1) maximum capacity
}