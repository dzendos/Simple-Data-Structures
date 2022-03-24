package queuedstack;

import linkedqueue.LinkedCircularBoundedQueue;

/* 
    Information about time complexity is written in interface file.

    @see IBoundedStack
*/

/*
    Method:
    To implement the stack using 2 queues, the following approach is used:
    1) We have 2 queues - main queue and additional one
    2) If we need to push new value onto the stack - We just push the new value onto the main queue
    3) If it is needed to pop the value We move all values from the main queue to additional queue except the last one and We delete the last element
       After that We swap additional and main queues (additional queue becomes the main one and vice versa)
    4) If it is needed to get the value of the top element We also move all elements except the last one into additional queue and after that return the value of the last element and push it in the additional queue
       After that We swap queues as well
*/

/**
 * Implements stack using two LinkedCircularBoundedQueues
 * 
 * @author  Evgeny Gerasimov
 * @version 1.0; 12.02.2022
 * @see     IBoundedStack
 * @see     LinkedCircularBoundedQueue
 * @param   <T> the type of elements held in this Queue
 */
public class QueuedBoundedStack<T> implements IBoundedStack<T> {

    private LinkedCircularBoundedQueue<T> queue1,    queue2;
    private LinkedCircularBoundedQueue<T> mainQueue, additionalQueue;

    int capacity;

    public QueuedBoundedStack(int capacity) {
        queue1 = new LinkedCircularBoundedQueue<T>(capacity);
        queue2 = new LinkedCircularBoundedQueue<T>(capacity);

        mainQueue       = queue1;
        additionalQueue = queue2;

        this.capacity   = capacity;
    }

    /**
     * Pushes new element onto the stack.
     * 
     * @param value that is pushed onto the stack
     */
    @Override
    public void push(T value) {
        mainQueue.offer(value);
    }

    /**
     * Removes top element of the stack and returns its value.
     * 
     * @return value of the top element of the stack
     */
    @Override
    public T pop() {
        mainQueue.moveItemsToQueue(additionalQueue, size() - 1);

        T value = mainQueue.poll();

        /* TODO: improve this swapping code */
        LinkedCircularBoundedQueue<T> tmpQueue = mainQueue;
        mainQueue       = additionalQueue;
        additionalQueue = tmpQueue;

        return value;
    }

    /**
     * Returns the value of the top element of the stack.
     * 
     * @return value of the top element of the stack
     */
    @Override
    public T top() {
        mainQueue.moveItemsToQueue(additionalQueue, size() - 1);

        T value = mainQueue.peek();

        if (value == null)
            return null;

        mainQueue.moveItemsToQueue(additionalQueue, 1);

        /* TODO: improve this swapping code */
        LinkedCircularBoundedQueue<T> tmpQueue = mainQueue;
        mainQueue       = additionalQueue;
        additionalQueue = tmpQueue;

        return value;
    }

    /**
     * Removes all elements from the stack.
     */
    @Override
    public void flush() {
        mainQueue.flush();
    }

    /**
     * Returns true if stack is empty.
     * 
     * @return true if stack is empty
     */
    @Override
    public boolean isEmpty() {
        return mainQueue.isEmpty();
    }

    /**
     * Returns true if there is no free space in the stack.
     * 
     * @return true if there is no free space in the stack
     */
    @Override
    public boolean isFull() {
        return mainQueue.isFull();
    }

    /**
     * Returns number of active elements in hte stack.
     * 
     * @return number of active elements in the stack
     */
    @Override
    public int size() {
        return mainQueue.size();
    }

    /**
     * Returns capacity of the stack.
     * 
     * @return capacity of the stack
     */
    @Override
    public int capacity() {
        return capacity;
    }
    
    /**
     * Returns elements of the stack.
     * 
     * @return elements of the stack
     */
    @Override
    public String toString() {
        return mainQueue.toString();
    }
}
