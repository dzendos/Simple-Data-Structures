package hashset;

/**
 * Implements DoubleHashSet ADT
 * <p>
 * 
 * @author  Evgeny Gerasimov
 * @version 1.0; 12.02.2022
 * @see     ISet
 * @param   <T> the type of elements held in this HashSet
 */
public class DoubleHashSet<T> implements ISet <T> {  
    boolean[] deleted;
 
    T[]       elements;
    int       size;
    int       capacity;
 
    /**
     * Creates new set
     */
    @SuppressWarnings("unchecked")
    public DoubleHashSet() {
        capacity = 11;
        elements = (T[])(new Object[capacity]);
        deleted  = new boolean[capacity];
 
        size     = 0;
    }
 
    /**
     * Adds new element into set if there are no such an element
     * 
     * @param item to add
     */
    @Override @SuppressWarnings("unchecked")
    public void add(T item) {
        if (contains(item))
            return;
        
        if (size == capacity) {
            deleted         = new boolean[capacity*2];
            T[] newElements = (T[])(new Object[capacity*2]);
 
            for (int i = 0; i < capacity; i++) {
                int hash = Math.abs(elements[i].hashCode()) % (capacity*2);
 
                for (int j = 0; j < capacity; j++) {
                    int index = Math.abs(hash + (hashCode2(elements[i])*j)%(capacity | 139)) % (capacity*2);
        
                    if (newElements[index] == null) {
                        newElements[index] = elements[i];
                        break;
                    }
                }
            }
            
            capacity *= 2;
 
            elements = newElements;
        }
 
        int hash = Math.abs(item.hashCode()) % capacity;
 
        for (int i = 0; i < capacity; i++) {
            int index = Math.abs(hash + (hashCode2(item)*i)%(capacity | 139)) % capacity;
 
            if (elements[index] == null) {
                elements[index] = item;
                size++;
 
                return;
            }
        }
    }
 
    /**
     * Removes element of set by item
     * 
     * @param item to remove
     */
    @Override
    public void remove(T item) {
        int index = find(item);
        if (index == -1)
            return;
 
        elements[index] = null;
        deleted[index]  = true;
 
        size--;
    }
 
    /**
     * Returns true if element exists in set and false in other case.
     * 
     * @param item element to find
     * @return true if element exists in set and false in other case
     */
    @Override
    public boolean contains(T item) {
        return find(item) == -1 ? false : true;
    }
 
    /**
     * Returns size of the set.
     * 
     * @return size of the set
     */
    @Override
    public int size() {
        return size;
    }
 
    /**
     * Returns true if the Queue contains no elements.
     * 
     * @return true if the Queue contains no elements
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }
 
    /**
     * Returns string with all values.
     * 
     * @return string with all values
     */
    @Override 
    public String toString() {
        String values = "";
 
        for (int i = 0; i < capacity; i++) {
            if (elements[i] != null) 
                values += elements[i].toString() + " ";
        }
 
        return values;
    }
 
    /**
     * Returns hash code by String interpretation of an element of type <T>
     * 
     * @param element which hash code We want to get
     * @return hash code of an element of type <T>
     */
    private int hashCode2(T element) {
        int hash = 0;
 
        String elementStr = element.toString();
 
        for (int i = 0; i < elementStr.length(); i++)
            hash += elementStr.charAt(i)*(i+1);
 
 
        return hash;
    }
 
    /**
     * Returns index of an element We want to find or null if such an element does not exist.
     * 
     * @param item to find
     * @return index of an element We want to find or null if such an element does not exist
     */
    private int find(T item) {
        int hash = Math.abs(item.hashCode()) % capacity;
 
        for (int i = 0; i < capacity; i++) {
            int index = Math.abs(hash + (hashCode2(item)*i)%(capacity | 139)) % capacity;
 
            if (elements[index] == null && !deleted[index])
                return -1;
 
            if (elements[index] == null)
                continue;
 
            if (elements[index].equals(item))
                return index;
        }
 
        return -1;
    }
 
    /**
     * Returns capacity of the set.
     * 
     * @return capacity of the set
     */
    public int capacity() {
        return capacity;
    }
}