package linkedlist;

/**
 * Provides a Node for LinkedList
 * 
 * @author Evgeny Gerasimov
 * @version 1.0; 12.02.2022
 * @param   <T> the type of elements held in this Queue
 */

public class Node <T> {
    T       value;
    Node<T> next;

    public Node(T value) {
        this.value = value;
        this.next  = null;
    }
}
