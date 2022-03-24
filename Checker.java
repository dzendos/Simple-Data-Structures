import hashset.DoubleHashSet;
import linkedqueue.LinkedCircularBoundedQueue;
import queuedstack.QueuedBoundedStack;

/**
 * This class contains functions that check data structures for reliability and correctness.
 * <p> 
 * Here included all possible situations that may arise when working with data structures.
 * 
 * @author Evgeny Gerasimov
 * @version 1.0; 12.02.2022
 */

public class Checker {
    /**
     * This test checks following situations:
     * 
     * <p>1) putting values
     * <p>2) overwriting elements
     * <p>3) getting values
     * <p>4) removing values
     * <p>5) removing values and getting values
     * <p>6) flushing elements
     */
    public void checkQueue() {
        LinkedCircularBoundedQueue<Integer> queue = new LinkedCircularBoundedQueue<>(4);

        queue.offer(1);

        System.out.println(queue.toString());

        queue.offer(2);
        queue.offer(3);

        System.out.println(queue.toString());

        queue.offer(4);

        System.out.println(queue.toString());

        queue.offer(5);
        queue.offer(6);
        queue.offer(7);

        System.out.println(queue.toString());

        queue.poll();

        System.out.println(queue.toString());

        queue.poll();

        System.out.println(queue.poll());

        queue.poll();

        queue.flush();

        System.out.println(queue.toString());

        queue.offer(10);

        System.out.println(queue.toString());

        System.out.println(queue.peek());
    }    

    /**
     * This test checks following situations:
     * 
     * <p>1) putting values
     * <p>2) overwriting elements
     * <p>3) getting values
     * <p>4) removing values
     * <p>5) removing values and getting values
     * <p>6) flushing elements
     * <p>7) how stack behaves when it is needed to change inside queues multiple times
     */
    public void checkStack() {
        QueuedBoundedStack<Integer> stack = new QueuedBoundedStack<>(4);

        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack.toString());

        stack.push(4);
        stack.push(5);

        System.out.println(stack.toString());

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

        System.out.println(stack.top()); // should be null

        stack.flush();

        stack.push(6);
        System.out.println(stack.top());

        stack.push(7);
        stack.push(8);
        stack.push(9);
        stack.push(10);

        System.out.println(stack.top());
        System.out.println(stack.toString());
        System.out.println(stack.top());
        System.out.println(stack.toString());       
        System.out.println(stack.top());
        System.out.println(stack.toString());

        stack.flush();

        System.out.println(stack.top()); 
    }
    
    /**
     * This test checks following situations:
     * 
     * <p>1) putting values
     * <p>2) removing values
     * <p>3) increasing capacity
     * <P>4) changing size of the set
     */
    public void checkSet() {
        
        DoubleHashSet<Integer> set = new DoubleHashSet<>();

        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(5);
        set.add(6);
        set.add(7);
        set.add(8);
        set.add(9);
        set.add(10);
        set.add(11);
        set.add(12);
        set.add(13);
        set.add(14);
        set.add(15);
        set.add(16);
        set.add(17);
        set.add(18);
        set.add(19);
        set.add(20);
        set.add(21);
        set.add(22);
        set.add(23);
        set.add(24);

        System.out.println(set.toString() + " " + set.capacity());

        set.remove(16);
        set.remove(15);
        set.remove(14);
        set.remove(13);
        set.remove(12);
        set.remove(11);
        set.remove(10);
        set.remove(9);
        set.remove(8);

        System.out.println(set.toString() + " " + set.capacity());
        
        set.remove(1);
        set.remove(2);
        set.remove(3);
        set.remove(4);
        set.remove(5);
        set.remove(6);
        set.remove(7);

        System.out.println(set.toString() + " " + set.capacity());
        
        set.remove(17);
        set.remove(18);
        set.remove(19);
        set.remove(24);
        set.remove(23);
        set.remove(22);
        set.remove(21);

        System.out.println(set.toString() + " " + set.capacity());

        set.remove(20);

        System.out.println(set.toString() + " " + set.capacity());

        set.add(95);

        System.out.println(set.contains(95));
        System.out.println(set.contains(0));
    }
}
