/**
 * @author Robby Renz Abeysinghe
 * Student Number: 3073208
 * Answer of Part B of Assignment 3
 */

import java.util.Comparator;

// an implementation of a priority queue using a linked binary tree heap
public class LinkedHeapPriorityQueue<K,V> extends AbstractPriorityQueue<K,V> {

    // primary collection of priority queue entries
    protected LinkedBinaryTree<Entry<K,V>> heap = new LinkedBinaryTree<>();

    // creates an empty priority queue based on the natural ordering of its keys
    public LinkedHeapPriorityQueue() {
	    super();
    }

    // createss an empty priority queue using the given comparator to order keys
    public LinkedHeapPriorityQueue(Comparator<K> comp) {
	    super(comp);
    }

    // protected utilities
    // exchanges the entries at positions i and j of the linked binary tree, positions will not be swapped
    protected void swap(Position<Entry<K,V>> a, Position<Entry<K,V>> b) {
        Position<Entry<K,V>> tempOne = a;
        a = b;
        b = tempOne;
    }

    // moves the entry at position j higher, if necessary, to restore the heap property
    protected void upheap(Position<Entry<K,V>> p) {
        // code here
    }

    // moves the entry at a position lower, if necessary, to restore the heap property
    protected void downheap(Position<Entry<K,V>> p) {
        // code here
    }

    // public methods
    // returns the number of entries in the priority queue
    public int size() {
        return heap.size();
    }

    // returns, but does not remove, an entry with minimal key
    public Entry<K,V> min() {
        if (heap.isEmpty())
            return null;
        return heap.root();
    }

    // inserts a key-value pair and returns the entry created
    public Entry<K,V> insert(K key, V value) throws IllegalArgumentException {
	checkKey(key); // auxiliary key-checking method (could throw exception)
	Entry<K,V> newest = new PQEntry<>(key, value);
	// code to add to the end of the list
	Position cursor = heap.root();
	// int keyTwo = (int) key;
	String binary = Integer.toBinaryString(heap.size());
	char[] binaryArr = binary.toCharArray();
	for (int i = 1; i < binaryArr.length - 1; i++) {
		if (binaryArr[i] == '1')
			cursor = heap.right(cursor);
		else
			cursor = heap.left(cursor);
	}
	// code to upheap the newly added entry
	return newest;
    }

    // removes and returns an entry with minimal key, if any
    public Entry<K,V> removeMin() {
        if (heap.isEmpty())
            return null;
        Entry<K,V> answer = this.root();
        // code here
        return answer;
    }

    // returns the last entry in the priority queue
    public Entry<K,V> returnsLast() {
        Entry<K,V> last;
        for (Entry e : heap)
            last = e;
        return last;
    }
}