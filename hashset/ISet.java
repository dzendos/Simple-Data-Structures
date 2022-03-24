package hashset;

/*
    In comments information about time complexity in the worst case of each method is given.
*/

/**
 * ADS for a Set
 * 
 * @param <T> the type of elements held in this Queue
 */
public interface ISet<T> {
    void    add(T item);      // Works for O(n^2) adds item in the set
    void    remove(T item);   // Works for O(1)   removes an item from a set
    boolean contains(T item); // Works for O(1)   checks if a item belongs to a set
    int     size();           // Works for O(1)   number of elements in a set
    boolean isEmpty();        // Works for O(1)   checks if the set is empty
}
