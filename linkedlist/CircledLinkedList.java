package linkedlist;

/**
 * Implements ILinkedList ADT using single linked list
 * <p>
 * Contains also auxiliary function toString() to represent elements of a Queue as a String 
 * 
 * @author  Evgeny Gerasimov
 * @version 1.0; 12.02.2022
 * @see     ILinkedList
 * @see     Node
 * @param   <T> the type of elements held in this Queue
 */

public class CircledLinkedList<T> implements ILinkedList<T> {
    private int     size;

    private Node<T> begin;
    private Node<T> end;

    private Node<T> head;
    private Node<T> tail;

    /**
     * Creates new empty list
     */
    public CircledLinkedList(int capacity) {
        if (capacity <= 0)
            throw new IllegalArgumentException("Incorrect capacity");

        Node<T> firstNode = new Node<>(null);
        begin = end = firstNode;
        for (int i = 1; i < capacity; i++) {
            Node<T> node = new Node<>(null);

            end.next     = node;
            end          = node;
        }

        end.next = begin;

        head = tail = begin;

        size = 0;
    }

    /**
     * Inserts an element to the rear of the Queue
     * 
     * @param value to add in queue
     */
    @Override
    public void add(T value) {
        size++;

        if (isEmpty()) {
            head.value = value;
            return;
        }
        
        tail.next.value = value;
        tail            = tail.next;
    }
    
    /**
     * Removes first element from the Queue and returns its value.
     * 
     * @throws - IllegalStateException if Queue is empty 
     * @return value of the first element in Queue
     */
    @Override
    public T poll() {
        if (isEmpty())
            throw new IllegalStateException("Queue is empty");

        T value = head.value;
        if (head == tail)
            head.value = null;
        else {
            head.value = null;
            head       = head.next;
        }

        size--;

        return value;
    }

    /**
     * Returns null if Queue is empty and value of the first element in Queue in other case.
     * 
     * @return null if Queue is empty and value of the first element in Queue in other case
     */
    @Override
    public T peek() {
        if (head == null)
            return null;
            
        return head.value;
    }

    /**
     * Removes all elements from the Queue.
     */
    @Override
    public void flush() {
        if (isEmpty())
            return;

        Node<T> node = head;
        do {
            node.value = null;
            node       = node.next;
        } while (node != tail);

        node.value = null;

        size = 0;
    }

    /**
     * Returns true if the Queue contains no elements.
     * 
     * @return true if the Queue contains no elements
     */
    @Override
    public boolean isEmpty() {
        return head.value == null;
    }

    /**
     * Returns size of the list.
     * 
     * @return size of the list
     */
    @Override
    public int size() {
        return size;
    }

        
    /**
     * Returns string with all values.
     * 
     * @return string with all values
     */
    @Override
    public String toString() {
        String values = "";
        Node<T> node = head;

        if (node.value == null)
            return "";

        do {
            values += node.value.toString() + " ";
            node = node.next;
        } while (node.value != null && node != head);

        return values;
    }
}
