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

    // exchanges the entries at positions i and j of the linked binary tree, positions will not be swapped
    protected void swap(Position<Entry<K,V>> a, Position<Entry<K,V>> b) {
        Entry<K,V> tempOne = a.getElement();
	a = b;
	b = tempOne;

	// long version:
        // a.getElement().setKey(b.getElement().getKey());
        // a.getElement().setValue(b.getElement().getValue());
        // b.getElement().setKey(tempOne.getKey());
        // b.getElement().setValue(tempOne.getValue());
    }

    // moves the entry at position j higher, if necessary, to restore the heap property
    // protected void upheap(Position<Entry<K,V>> a) {
    //     while 
    // }

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
}

